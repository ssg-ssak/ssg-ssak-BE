package ssgssak.ssgpointuser.domain.user.application;

import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.user.dto.*;
import ssgssak.ssgpointuser.domain.user.entity.User;


public interface UserService {

    void updateUserInfo(UserUpdateInfoDto updateInfoDto, String uuid);

    void updateUserPw(UserUpdatePwDto updatePwDto, String uuid);

    void updateUserPointPw(UserUpdatePointPwDto updatePointPwDto, String uuid);

    // 4. 유저 UUID로 조회
    User getUserByUUID(String userUUID);

    // 5. 유저 휴대폰 번호로 조회
    UserPhoneSearchResponseDto searchPhoneNumber(String phoneNumber, String name);

    // 6. 유저 정보 조회
    @Transactional(readOnly = true)
    UserGetResponseDto getUserInfo(String uuid);
}
