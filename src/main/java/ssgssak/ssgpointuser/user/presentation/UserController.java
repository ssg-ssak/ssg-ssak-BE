package ssgssak.ssgpointuser.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.user.application.UserConverter;
import ssgssak.ssgpointuser.user.application.UserServiceImpl;
import ssgssak.ssgpointuser.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.user.vo.UserUpdateInfoInVo;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl userService;
    private final UserConverter userConverter;

    /**
     * 회원정보 수정하기
     */
    @PutMapping("/information")
    public void modifyUserInfo(@RequestBody UserUpdateInfoInVo userUpdateInfoInVo) {
        UserUpdateInfoDto updateInfoDto = userConverter.updateInfoVoToDto(userUpdateInfoInVo, userUpdateInfoInVo.getUserUUID());
        userService.updateUserInfo(updateInfoDto);
    }


}
