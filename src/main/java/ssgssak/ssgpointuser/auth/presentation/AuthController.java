package ssgssak.ssgpointuser.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.auth.application.AuthConverter;
import ssgssak.ssgpointuser.auth.application.AuthServiceImpl;
import ssgssak.ssgpointuser.auth.dto.AuthSignUpDto;
import ssgssak.ssgpointuser.auth.vo.AuthSignUpVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthServiceImpl authService;
    private final AuthConverter authConverter;

    /**
     * 회원가입
     */
    @PostMapping("/sign-up")
    public void authSignUp(@RequestBody AuthSignUpVo authSignUpVo) {
        AuthSignUpDto authSignUpDto = authConverter.signUpVoToDto(authSignUpVo);
        authService.signUp(authSignUpDto);
    }
}
