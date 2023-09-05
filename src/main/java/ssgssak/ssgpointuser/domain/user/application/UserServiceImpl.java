package ssgssak.ssgpointuser.domain.user.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.user.dto.UserPhoneSearchResponseDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdateInfoDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePointPwDto;
import ssgssak.ssgpointuser.domain.user.dto.UserUpdatePwDto;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    /**
     * 유저
     * 1. 유저 정보 수정
     * 2. 유저 비밀번호 수정
     * 3. 유저 포인트 비밀번호 수정
     * 4. 유저 UUID로 조회
     * 5. 유저 휴대폰 번호로 조회
     */

    // 1. 유저 정보 수정
    @Override
    public void updateUserInfo(UserUpdateInfoDto updateInfoDto, String uuid) {
        User user = getUserByUUID(uuid);
        user.updateUserInfo(updateInfoDto.getEmail(), updateInfoDto.getAddress());
    }

    // 2. 유저 비밀번호 수정
    @Override
    public void updateUserPw(UserUpdatePwDto updatePwDto, String uuid) {
        User user = getUserByUUID(uuid);
        user.updatePassword(updatePwDto.getPassword());
    }

    // 3. 유저 포인트 비밀번호 수정
    @Override
    public void updateUserPointPw(UserUpdatePointPwDto updatePointPwDto, String uuid) {
        User user = getUserByUUID(uuid);
        user.updatePointPw(updatePointPwDto.getPointPassword());
    }


    // 4. 유저 UUID로 조회
    @Override
    @Transactional(readOnly = true)
    public User getUserByUUID(String userUUID) {
        User user = userRepository.findUserByUserUUID(userUUID)
                .orElseThrow(()->new NoSuchElementException());
        return user;
    }

    // 5. 유저 휴대폰 번호로 조회
    @Override
    @Transactional(readOnly = true)
    public UserPhoneSearchResponseDto searchPhoneNumber(String phoneNumber, String userName) {
        User user = userRepository.findByUserNameAndPhoneNumber(phoneNumber, userName)
                .orElseThrow(()-> new NoSuchElementException("해당하는 유저가 존재하지 않습니다"));
        return UserPhoneSearchResponseDto.builder()
                .userName(user.getUserName())
                .userId(user.getUserId())
                .receiverUUID(user.getUserUUID())
                .build();
    }
}

