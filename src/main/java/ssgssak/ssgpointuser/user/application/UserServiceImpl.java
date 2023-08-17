package ssgssak.ssgpointuser.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.user.dto.UserUpdatePointPwDto;
import ssgssak.ssgpointuser.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.user.entity.User;
import ssgssak.ssgpointuser.user.infrastructure.UserRepository;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public void updateUserInfo(UserUpdateInfoDto updateInfoDto) {
        User updateUser = userConverter.updateInfoDtoToUser(updateInfoDto);
        userRepository.save(updateUser);
    }

    @Override
    public void updateUserPw(UserUpdatePwDto updatePwDto) {
        User updateUser = userConverter.updatePwDtoToUser(updatePwDto);
        userRepository.save(updateUser);
    }

    @Override
    public void updateUserPointPw(UserUpdatePointPwDto updatePointPwDto) {
        User updateUser = userConverter.updatePointPwDtoToUser(updatePointPwDto);
        userRepository.save(updateUser);
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

