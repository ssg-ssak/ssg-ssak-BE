package ssgssak.ssgpointuser.user.application;

import ssgssak.ssgpointuser.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.user.dto.UserUpdatePointPwDto;
import ssgssak.ssgpointuser.user.dto.UserUpdatePwDto;


public interface UserService {

    void updateUserInfo(UserUpdateInfoDto updateInfoDto);

    void updateUserPw(UserUpdatePwDto updatePwDto);

    void updateUserPointPw(UserUpdatePointPwDto updatePointPwDto);
}
