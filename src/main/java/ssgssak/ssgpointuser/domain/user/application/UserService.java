package ssgssak.ssgpointuser.domain.user.application;

import ssgssak.ssgpointuser.domain.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePointPwDto;


public interface UserService {

    void updateUserInfo(UserUpdateInfoDto updateInfoDto, String uuid);

    void updateUserPw(UserUpdatePwDto updatePwDto, String uuid);

    void updateUserPointPw(UserUpdatePointPwDto updatePointPwDto, String uuid);
}
