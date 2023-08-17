package ssgssak.ssgpointuser.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ssgssak.ssgpointuser.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.user.entity.User;
import ssgssak.ssgpointuser.user.infrastructure.UserRepository;
import ssgssak.ssgpointuser.user.vo.UserUpdateInfoInVo;
import ssgssak.ssgpointuser.user.dto.UserUpdatePointPwDto;
import ssgssak.ssgpointuser.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.user.vo.UserUpdatePointPwInVo;
import ssgssak.ssgpointuser.user.vo.UserUpdatePwInVo;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class UserConverterImpl implements UserConverter{
    private final UserRepository userRepository;

    @Override
    public UserUpdateInfoDto updateInfoVoToDto(UserUpdateInfoInVo userUpdateInfoInVo, String userUUID) {
        return UserUpdateInfoDto.builder()
                .userUUID(userUUID)
                .address(userUpdateInfoInVo.getAddress())
                .email(userUpdateInfoInVo.getEmail())
                .build();
    }

    @Override
    public User updateInfoDtoToUser(UserUpdateInfoDto updateInfoDto) {
        User user = getUserByUUID(updateInfoDto.getUserUUID());
        return user.toBuilder()
                .address(updateInfoDto.getAddress())
                .email(updateInfoDto.getEmail())
                .build();
    }

    @Override
    public UserUpdatePwDto updatePwVoToDto(UserUpdatePwInVo userUpdatePwInVo, String uuid) {
        return UserUpdatePwDto.builder()
                .uuid(uuid)
                .password(userUpdatePwInVo.getPassword())
                .build();
    }

    @Override
    public User updatePwDtoToUser(UserUpdatePwDto updatePwDto) {
        User user = getUserByUUID(updatePwDto.getUuid());
        return user.toBuilder()
                .userPassword(updatePwDto.getPassword())
                .build();
    }

    @Override
    public UserUpdatePointPwDto updatePointPwVoToDto(UserUpdatePointPwInVo userUpdatePointPwInVo, String UUID) {
        return UserUpdatePointPwDto.builder()
                .uuid(UUID)
                .pointPassword(userUpdatePointPwInVo.getPointPassword())
                .build();
    }

    @Override
    public User updatePointPwDtoToUser(UserUpdatePointPwDto updatePointPwDto) {
        User user = getUserByUUID(updatePointPwDto.getUuid());
        return user.toBuilder()
                .pointPassword(updatePointPwDto.getPointPassword())
                .build();
    }


    /**
     * 유저를 UUID로 검색
     */
    public User getUserByUUID(String userUUID) {
        User user = userRepository.findUserByUserUUID(userUUID)
                .orElseThrow(()->new NoSuchElementException());
        return user;
    }

}
