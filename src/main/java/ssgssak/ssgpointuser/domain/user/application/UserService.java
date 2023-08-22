package ssgssak.ssgpointuser.domain.user.application;

import ssgssak.ssgpointuser.domain.user.dto.UserPhoneSearchDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePointPwDto;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.vo.UserPhoneSearchingOutVo;


public interface UserService {

    void updateUserInfo(UserUpdateInfoDto updateInfoDto, String uuid);

    void updateUserPw(UserUpdatePwDto updatePwDto, String uuid);

    void updateUserPointPw(UserUpdatePointPwDto updatePointPwDto, String uuid);

    // 4. 유저 UUID로 조회
    User getUserByUUID(String userUUID);

    // 5. 유저 휴대폰 번호로 조회
    UserPhoneSearchingOutVo searchPhoneNumber(String phoneNumber, String name);
}
