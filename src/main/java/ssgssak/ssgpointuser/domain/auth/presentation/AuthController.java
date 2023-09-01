package ssgssak.ssgpointuser.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.auth.application.AuthServiceImpl;
import ssgssak.ssgpointuser.domain.auth.dto.AuthDeactivateSignUpDto;
import ssgssak.ssgpointuser.domain.auth.dto.AuthLoginRequestDto;
import ssgssak.ssgpointuser.domain.auth.dto.AuthLoginResponseDto;
import ssgssak.ssgpointuser.domain.auth.dto.AuthSignUpDto;
import ssgssak.ssgpointuser.domain.auth.vo.AuthDeactivateSignUpVo;
import ssgssak.ssgpointuser.domain.auth.vo.AuthLoginInVo;
import ssgssak.ssgpointuser.domain.auth.vo.AuthLoginOutVo;
import ssgssak.ssgpointuser.domain.auth.vo.AuthSignUpVo;

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
    public void deactivateAccount(@RequestBody AuthDeactivateSignUpVo deactivateVo) {
        AuthDeactivateSignUpDto deactivateDto = modelMapper.map(deactivateVo, AuthDeactivateSignUpDto.class);
        authService.deactivateAccount(deactivateDto,deactivateVo.getUserUUID());
    }

    // 3. 로그인
    @PostMapping("/log-in")
    public ResponseEntity<AuthLoginOutVo> login(@RequestBody AuthLoginInVo inVo) {
        AuthLoginResponseDto responseDto = authService.userLogin(modelMapper.map(inVo, AuthLoginRequestDto.class));
        AuthLoginOutVo outVo = modelMapper.map(responseDto, AuthLoginOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

}
