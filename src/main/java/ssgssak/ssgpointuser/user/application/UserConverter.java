package ssgssak.ssgpointuser.user.application;

import lombok.NonNull;
import ssgssak.ssgpointuser.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.user.entity.User;
import ssgssak.ssgpointuser.user.vo.UserUpdateInfoInVo;
import ssgssak.ssgpointuser.user.vo.UserUpdatePwInVo;

public interface UserConverter {

    UserUpdateInfoDto updateInfoVoToDto(UserUpdateInfoInVo userUpdateInfoInVo, String UUID);

    User updateInfoDtoToUser(UserUpdateInfoDto updateInfoDto);

    UserUpdatePwDto updatePwVoToDto(UserUpdatePwInVo userUpdatePwInVo, String uuid);

    User updatePwDtoToUser(UserUpdatePwDto updatePwDto);
}
