package ssgssak.ssgpointuser.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePointPwDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void updateUserInfo(UserUpdateInfoDto updateInfoDto, String uuid) {
        User user = getUserByUUID(uuid);
        user.updateUserInfo(updateInfoDto.getEmail(), updateInfoDto.getAddress());

    }

    @Override
    public void updateUserPw(UserUpdatePwDto updatePwDto, String uuid) {
        User user = getUserByUUID(uuid);
        user.updatePassword(updatePwDto.getPassword());
    }

    @Override
    public void updateUserPointPw(UserUpdatePointPwDto updatePointPwDto, String uuid) {
        User user = getUserByUUID(uuid);
        user.updatePointPw(updatePointPwDto.getPointPassword());
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

