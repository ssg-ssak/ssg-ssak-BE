package ssgssak.ssgpointuser.domain.auth.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.auth.dto.*;
import ssgssak.ssgpointuser.domain.auth.entity.CustomUserDetails;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;
import ssgssak.ssgpointuser.global.common.exception.UnAuthorizedException;
import ssgssak.ssgpointuser.global.config.jwt.JwtTokenProvider;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    /**
     * auth
     * 1. 로그인
     * 2. 회원가입
     * 3. 바코드 넘버 생성
     * 4. 바코드 넘버 중복확인
     * 5. UUID 생성
     * 6. UUID 중복 확인
     * 7. 회원 탈퇴
     * 8. 패스워드 일치 검사
     * 9. uuid로 유저 조회
     * 10. 유저 이름, 휴대폰 번호로 유저 Login Id 조회
     */

    // 1. 로그인
    @Override
    public AuthLoginResponseDto userLogin(AuthLoginRequestDto requestDto) {
        // authenticationManager에서 입력받은 id,pw로 인증을 진행함
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    requestDto.getLoginId(),
                    requestDto.getPassword());
            log.info("auth정보 : " + authToken.getPrincipal() +", " + authToken.getCredentials());
            authenticationManager.authenticate(authToken);
        }
        // 유저 ID or PW가 불일치할때
        catch (Exception e) {
            log.error("인증오류 : ",e);
            throw new UnAuthorizedException("인증되지 않은 사용자입니다");
        }
        // 인증을 통과했으면 새로운 토큰을 return
        User user = userRepository.findByUserId(requestDto.getLoginId()).orElseThrow();
        String token = jwtTokenProvider.generateToken(new CustomUserDetails(user));
        log.info("token : "+token);
        return AuthLoginResponseDto.builder().token(token).build();
    }

    /**
     * 회원가입
     */
    @Override
    public void signUp(AuthSignUpDto authSignUpDto) {
        String newUUID = generateUUID();
        // 비밀번호 해싱
        String hashPassword = passwordEncoder.encode(authSignUpDto.getUserPassword());
        authSignUpDto = authSignUpDto.toBuilder().userPassword(hashPassword).build();
        log.info("hashPw : " + hashPassword);
        User newUser = User.builder()
                .userUUID(newUUID)
                .barcodeNumber("init")
                .build();
        // dto로 User생성
        modelMapper.map(authSignUpDto,newUser);
        log.info("new hashPw : " + newUser.getUserPassword());
        // id를 얻기위해 save
        userRepository.save(newUser);
        // 바코드 생성 및 설정
        String newBarcode = generateBarcodeNumber(newUser.getId().toString());
        newUser.setNewBarcodeNumber(newBarcode);
        // 유저 저장
        userRepository.save(newUser);
    }

    /**
     * 바코드 넘버 생성
     */
    @Override
    public String generateBarcodeNumber(String id) {
        Random random = new Random();
        int length = id.length();
        String uniqueIdentifier;
        do {
        uniqueIdentifier =
                id.substring(0, length / 2)
                + random.ints(0, 10)
                        .limit(10-length)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining())
                + id.substring(length / 2, length);
        log.info("고유식별자 :" + uniqueIdentifier);
        } while (checkBarcodeNumberDuplicate(uniqueIdentifier));
        return "935012" + uniqueIdentifier;
    }

    /**
     * 바코드 넘버 중복 확인
     */
    @Override
    public boolean checkBarcodeNumberDuplicate(String barcodeNumber) {
        Optional<User> user = userRepository.findUserByBarcodeNumber(barcodeNumber);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * UUID 생성
     */
    @Override
    public String generateUUID() {
        String newUUID;
        do {
            newUUID = UUID.randomUUID().toString();
        } while (checkUuidDuplicate(newUUID));
        return newUUID;
    }

    /**
     * UUID 중복 확인
     */
    @Override
    public boolean checkUuidDuplicate(String UUID) {
        Optional<User> user = userRepository.findUserByUserUUID(UUID);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 회원 탈퇴
     */
    @Override
    public void deactivateAccount(AuthDeactivateSignUpDto deactivateDto, String uuid) {
        User user = getUserByUUID(uuid);
        String userPassword = deactivateDto.getUserPassword();
        if (validateUserPassword(userPassword, uuid)) {
            user.deactivateAccount(LocalDateTime.now());
            userRepository.save((user));
        } else {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다");
        }
    }


    /**
     * 패스워드 일치 검사
     */
    @Override
    @Transactional(readOnly = true)
    public boolean validateUserPassword(String userPassword, String uuid) {
        User user = getUserByUUID(uuid);
        if (user.getUserPassword().equals(userPassword)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * uuid로 유저 조회
     */
    @Override
    @Transactional(readOnly = true)
    public User getUserByUUID(String uuid) {
        User user = userRepository.findUserByUserUUID(uuid)
                .orElseThrow(() -> new NoSuchElementException("해당하는 유저가 없습니다"));
        return user;
    }

    // 10. 유저 이름, 휴대폰 번호로 유저 Login Id 조회
    @Override
    @Transactional(readOnly = true)
    public AuthGetLoginIdResponseDto getLoginId(AuthGetLoginIdRequestDto requestDto) {
        User user = userRepository.findByUserNameAndPhoneNumber(requestDto.getUserName(), requestDto.getPhoneNumber())
                .orElseThrow(() -> new NoSuchElementException("해당하는 유저가 없습니다"));
        return AuthGetLoginIdResponseDto.builder().loginId(user.getUserId()).build();
    }
}
