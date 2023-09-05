package ssgssak.ssgpointuser.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.user.application.UserServiceImpl;
import ssgssak.ssgpointuser.domain.user.dto.UserPhoneSearchResponseDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.domain.user.vo.*;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePointPwDto;

import java.security.Principal;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
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
    public void modifyUserInfo(@RequestBody UserUpdateInfoInVo userUpdateInfoInVo, Principal principal) {
        UserUpdateInfoDto updateInfoDto = modelMapper.map(userUpdateInfoInVo, UserUpdateInfoDto.class);
        log.info("uuid " + principal.getName() );
        userService.updateUserInfo(updateInfoDto, principal.getName());
    }

    // 2. 비밀번호 변경하기
    @PutMapping("/password")
    public void modifyUserPassword(@RequestBody UserUpdatePwInVo userUpdatePwInVo, Principal principal) {
        UserUpdatePwDto updatePwDto = modelMapper.map(userUpdatePwInVo, UserUpdatePwDto.class);
        userService.updateUserPw(updatePwDto, principal.getName());
    }

    // 3. 포인트 비밀번호 변경하기
    @PutMapping("/point-password")
    public void modifyUserPointPw(@RequestBody UserUpdatePointPwInVo userUpdatePointPwInVo, Principal principal) {
        UserUpdatePointPwDto updatePointPwDto = modelMapper.map(userUpdatePointPwInVo, UserUpdatePointPwDto.class);
        userService.updateUserPointPw(updatePointPwDto, principal.getName());
    }

    // 4. 휴대폰 번호로 유저 조회
    @GetMapping("/by/phone")
    public ResponseEntity<UserPhoneSearchingOutVo> searchingPhoneNum(@RequestParam String phoneNumber,
                                                                     @RequestParam String userName) {
        UserPhoneSearchResponseDto responseDto = userService.searchPhoneNumber(phoneNumber, userName);
        UserPhoneSearchingOutVo outVo = modelMapper.map(responseDto, UserPhoneSearchingOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
