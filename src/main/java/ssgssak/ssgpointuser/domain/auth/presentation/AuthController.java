package ssgssak.ssgpointuser.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.auth.application.AuthServiceImpl;
import ssgssak.ssgpointuser.domain.auth.dto.AuthSignUpDto;
import ssgssak.ssgpointuser.domain.auth.vo.AuthSignUpVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthController {
    private final AuthServiceImpl authService;
    private final ModelMapper modelMapper;

    /**
     * 회원 가입
     */
    @PostMapping("/sign-up")
    public void authSignUp(@RequestBody AuthSignUpVo authSignUpVo) {
        log.info("Vo" + authSignUpVo);
        AuthSignUpDto authSignUpDto = modelMapper.map(authSignUpVo, AuthSignUpDto.class);
        log.info("auth" + authSignUpDto);
        authService.signUp(authSignUpDto);
    }

//    /**
//     * 회원 탈퇴
//     */
//    @PutMapping("/auth/deactivate-account")
//    public void deactivateAccount(@RequestBody AuthDeactivateSignUpVo deactivateVo) {
//        AuthDeactivateSignUpDto deactivateDto = modelMapper.map(deactivateVo, AuthDeactivateSignUpDto.class);
//        authService.deactivateAccount(deactivateDto,deactivateVo.getUserUUID());
//    }

}
