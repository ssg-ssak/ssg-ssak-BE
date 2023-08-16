package ssgssak.ssgpointuser.user.application;

import ssgssak.ssgpointuser.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.user.entity.User;

import java.util.Optional;

public interface UserService {

    void updateUserInfo(UserUpdateInfoDto updateInfoDto);

}
