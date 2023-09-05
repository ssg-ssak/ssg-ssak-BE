package ssgssak.ssgpointuser.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.auth.application.AuthServiceImpl;
import ssgssak.ssgpointuser.domain.auth.dto.*;
import ssgssak.ssgpointuser.domain.auth.vo.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthController {
    private final AuthServiceImpl authService;
    private final ModelMapper modelMapper;

    /**
     * Auth
     * 1. 회원가입
     * 2. 회원탈퇴
     * 3. 로그인
     * 4. 아이디 찾기
     */

    // 1. 회원가입
    @PostMapping("/sign-up")
    public void authSignUp(@RequestBody AuthSignUpVo authSignUpVo) {
        log.info("Vo" + authSignUpVo);
        AuthSignUpDto authSignUpDto = modelMapper.map(authSignUpVo, AuthSignUpDto.class);
        log.info("auth" + authSignUpDto);
        authService.signUp(authSignUpDto);
    }

    // 2. 회원탈퇴
    @PutMapping("/deactivate-account")
    public void deactivateAccount(@RequestBody AuthDeactivateSignUpVo deactivateVo, Principal principal) {
        AuthDeactivateSignUpDto deactivateDto = modelMapper.map(deactivateVo, AuthDeactivateSignUpDto.class);
        authService.deactivateAccount(deactivateDto, principal.getName());
    }

    // 3. 로그인
    @PostMapping("/log-in")
    public ResponseEntity<AuthLoginOutVo> login(@RequestBody AuthLoginInVo inVo) {
        AuthLoginResponseDto responseDto = authService.userLogin(modelMapper.map(inVo, AuthLoginRequestDto.class));
        AuthLoginOutVo outVo = modelMapper.map(responseDto, AuthLoginOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

    // 4. 아이디 찾기
    @GetMapping("/login-id")
    public ResponseEntity<AuthGetLoginIdOutVo> getLoginId(AuthGetLoginIdInVo inVo) {
        AuthGetLoginIdResponseDto responseDto = authService.getLoginId(modelMapper.map(inVo, AuthGetLoginIdRequestDto.class));
        AuthGetLoginIdOutVo outVo = modelMapper.map(responseDto, AuthGetLoginIdOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
