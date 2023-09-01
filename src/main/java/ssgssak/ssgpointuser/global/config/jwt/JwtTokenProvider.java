package ssgssak.ssgpointuser.global.config.jwt;

import com.nimbusds.openid.connect.sdk.claims.CommonClaimsSet;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.auth.entity.CustomUserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final Environment env; // application.yml에서 설정한 설정값

    /**
     * TokenProvider
     * 1. 토큰에서 uuid 가져오기
     * 2. Claims에서 원하는 claim 값 추출
     * 3. 토큰에서 모든 claims 추출
     * 4. 토큰 key 디코드
     * 5,6. 토큰 생성
     * 7. 토큰 유효성 검사
     * 8. 토큰 만료 여부 검사
     * 9. 토큰에서 만료일 추출
     */

    // 1. 토큰에서 uuid 가져오기 가져오기
    public String getUUID(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 2. Claims에서 원하는 값(T) 추출 : (token)과, (Claims를 받아서 원하는 값 T를 반환하는 function)을 입력받아서 -> T를 return
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // 3. 토큰에서 모든 claim 추출 : token을 파싱해서 모든 claim 값을 추출한다
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 4. 토큰 key 디코드 : env에 저장된 키로, 들어온 토큰을 파싱
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(env.getProperty("JWT.SECRET_KEY", String.class));
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 5,6. override하여 토큰 생성 todo: generateToken을 왜 두번 사용하는건지 모르겠음
    public String generateToken(CustomUserDetails userDetails) {
        return generateToken(Map.of(), userDetails);
    }

    public String generateToken(
            Map<String, Objects> extractClaims,
            CustomUserDetails userDetails
    ) {
        return Jwts.builder()
                // claims 설정
                .setClaims(extractClaims)
                // CustomUserDetails에서 getUsername으로 userId를 가져오고, 토큰의 subjcet로 설정함
                .setSubject(userDetails.getUsername())
                // 추가적으로 토큰에 유저의 uuid값을 넣어줌
                .claim("uuid", userDetails.getUsername())
                // 현재 시간을 발급시간으로 설정
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                // 만료일은, 현재시간 + env에 저장된 만료시간으로 설정
                .setExpiration(new java.util.Date(System.currentTimeMillis() + env.getProperty("JWT.EXPIRATION_TIME", Long.class)))
                // 마지막으로 env에 저장된 key로 해싱작업
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    // 7. 토큰 유효성 검사 : 토큰 subject에서 가져온 uuid와, CustomUserDetails에 저장된 uuid값이 같은지 확인 + 토큰 만료일 검사값이 false인지 확인
    public boolean validateToken(String token, CustomUserDetails userDetails) {
        final String uuid = getUUID(token);
        return (uuid.equals(userDetails.getUsername()) && isTokenExpired(token) == false);
    }

    // 8. 토큰 만료 여부 검사 : 토큰에서 추출한 만료일이, 현재시간보다 이전인지 확인
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new java.util.Date());
    }

    // 9. 토큰에서 만료일 추출
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


}
