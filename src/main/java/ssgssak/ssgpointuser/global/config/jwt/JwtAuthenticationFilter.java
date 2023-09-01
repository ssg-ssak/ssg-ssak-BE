package ssgssak.ssgpointuser.global.config.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ssgssak.ssgpointuser.domain.auth.entity.CustomUserDetails;
import ssgssak.ssgpointuser.domain.auth.entity.CustomUserDetailsService;

import java.io.IOException;

/**
 * Request 하나가 들어올때마다 실행되는 OncePerRequestFilter를 extends하고,
 * doFilterInternal을 오버라이드하여 사용한다
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization"); // 토큰을 받아오는 필드는, request 헤더에서 "Authorization"임
        final String jwt;
        final String uuid; // uuid를 토큰에서 가져올것임

        // 헤더가 null이거나, "Bearer"로 시작하지 않는다면 토큰 인증을 진행하지 않음
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 토큰 인증 진행
        jwt = authHeader.substring(7); // "Bearer " 뒷부분이 모두 jwt 토큰임
        uuid = jwtTokenProvider.getUUID(jwt);    // 토큰에서 uuid를 추출

        // 만약 loginId가 null이 아니고, SecurityContextHolder에 authentication이 없고, 토큰이 유효성 검사를 통과했다면 authentication 생성
        if (uuid != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            CustomUserDetails userDetails = this.customUserDetailsService.loadUserByUUID(uuid);
            // 토큰이 유효하다면 authentication 생성
            if (jwtTokenProvider.validateToken(jwt, userDetails)) {
                // todo: 그냥 authentication 생성하는걸로 이해했는데 맞는지 확인, 그리고 credentials가 뭔지 확인
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                // authentication을 request값을 사용하여 설정 todo: 무슨 역할인지 정확하게 모르겠음
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // SecurityContextHolder에 authentication을 집어넣음
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            filterChain.doFilter(request, response);
        }
    }
}
