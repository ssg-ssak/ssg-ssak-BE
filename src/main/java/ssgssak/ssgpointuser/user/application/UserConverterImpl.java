package ssgssak.ssgpointuser.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ssgssak.ssgpointuser.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.user.entity.User;
import ssgssak.ssgpointuser.user.infrastructure.UserRepository;
import ssgssak.ssgpointuser.user.vo.UserUpdateInfoInVo;

import java.util.NoSuchElementException;
import java.util.Optional;

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


    /**
     * 유저를 UUID로 검색
     */
    public User getUserByUUID(String userUUID) {
        User user = userRepository.findUserByUserUUID(userUUID)
                .orElseThrow(()->new NoSuchElementException());
        return user;
    }

}
