package ssgssak.ssgpointuser.user.application;

import ssgssak.ssgpointuser.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.user.entity.User;
import ssgssak.ssgpointuser.user.vo.UserUpdateInfoInVo;

public interface UserConverter {

    UserUpdateInfoDto updateInfoVoToDto(UserUpdateInfoInVo userUpdateInfoInVo, String UUID);

    User updateInfoDtoToUser(UserUpdateInfoDto updateInfoDto);

}
