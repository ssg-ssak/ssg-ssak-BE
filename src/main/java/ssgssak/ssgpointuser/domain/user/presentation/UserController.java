package ssgssak.ssgpointuser.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.user.application.UserServiceImpl;
import ssgssak.ssgpointuser.domain.user.dto.UserPhoneSearchDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.domain.user.vo.*;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePointPwDto;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    /**
     * 유저
     * 1. 회원정보 수정하기
     * 2. 비밀번호 변경하기
     * 3. 포인트 비밀번호 변경하기
     * 4. 휴대폰 번호로 유저 조회
     */

    // 1. 회원정보 수정하기
    @PutMapping("/information")
    public void modifyUserInfo(@RequestBody UserUpdateInfoInVo userUpdateInfoInVo) {
        UserUpdateInfoDto updateInfoDto = modelMapper.map(userUpdateInfoInVo, UserUpdateInfoDto.class);
        userService.updateUserInfo(updateInfoDto, userUpdateInfoInVo.getUserUUID());
    }

    // 2. 비밀번호 변경하기
    @PutMapping("/password")
    public void modifyUserPassword(@RequestBody UserUpdatePwInVo userUpdatePwInVo) {
        UserUpdatePwDto updatePwDto = modelMapper.map(userUpdatePwInVo, UserUpdatePwDto.class);
        userService.updateUserPw(updatePwDto, userUpdatePwInVo.getUuid());
    }

    // 3. 포인트 비밀번호 변경하기
    @PutMapping("/point-password")
    public void modifyUserPointPw(@RequestBody UserUpdatePointPwInVo userUpdatePointPwInVo) {
        UserUpdatePointPwDto updatePointPwDto = modelMapper.map(userUpdatePointPwInVo, UserUpdatePointPwDto.class);
        userService.updateUserPointPw(updatePointPwDto, userUpdatePointPwInVo.getUuid());
    }

    // 4. 휴대폰 번호로 유저 조회
    @GetMapping("/search/phone")
    public ResponseEntity<UserPhoneSearchingOutVo> searchingPhoneNum(@RequestParam String phoneNumber,
                                                                     @RequestParam String userName) {
        UserPhoneSearchingOutVo outVo = userService.searchPhoneNumber(phoneNumber, userName);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
