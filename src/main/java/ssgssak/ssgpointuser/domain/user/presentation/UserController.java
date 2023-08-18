package ssgssak.ssgpointuser.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.domain.user.application.UserServiceImpl;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.domain.user.vo.UserUpdateInfoInVo;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePointPwDto;
import ssgssak.ssgpointuser.domain.user.vo.UserUpdatePointPwInVo;
import ssgssak.ssgpointuser.domain.user.vo.UserUpdatePwInVo;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    /**
     * 회원정보 수정하기
     */
    @PutMapping("/information")
    public void modifyUserInfo(@RequestBody UserUpdateInfoInVo userUpdateInfoInVo) {
        UserUpdateInfoDto updateInfoDto = modelMapper.map(userUpdateInfoInVo, UserUpdateInfoDto.class);
        userService.updateUserInfo(updateInfoDto, userUpdateInfoInVo.getUserUUID());
    }

    /**
     * 비밀번호 변경하기
     */
    @PutMapping("/password")
    public void modifyUserPassword(@RequestBody UserUpdatePwInVo userUpdatePwInVo) {
        UserUpdatePwDto updatePwDto = modelMapper.map(userUpdatePwInVo, UserUpdatePwDto.class);
        userService.updateUserPw(updatePwDto, userUpdatePwInVo.getUuid());
    }

    /**
     * 포인트 비밀번호 변경하기
     */
    @PutMapping("/point-password")
    public void modifyUserPointPw(@RequestBody UserUpdatePointPwInVo userUpdatePointPwInVo) {
        UserUpdatePointPwDto updatePointPwDto = modelMapper.map(userUpdatePointPwInVo, UserUpdatePointPwDto.class);
        userService.updateUserPointPw(updatePointPwDto,userUpdatePointPwInVo.getUuid());
    }

}
