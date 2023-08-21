package ssgssak.ssgpointuser.domain.auth.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.auth.dto.AuthDeactivateSignUpDto;
import ssgssak.ssgpointuser.domain.auth.dto.AuthSignUpDto;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    /**
     * 회원가입
     */
    public void signUp(AuthSignUpDto authSignUpDto) {
        String newUUID = generateUUID();
        User newUser = User.builder()
                .userId(authSignUpDto.getUserId())
                .userUUID(newUUID)
                .userName(authSignUpDto.getUserName())
                .userPassword(authSignUpDto.getUserPassword())
                .email(authSignUpDto.getEmail())
                .address(authSignUpDto.getAddress())
                .phoneNumber(authSignUpDto.getPhoneNumber())
                .barcodeNumber("init")
                .build();
        log.info("id : " + newUser.getId());
        userRepository.save(newUser);
        String id = userRepository.findUserByUserUUID(newUUID).get().getId().toString();
        String newBarcode = generateBarcodeNumber(id);
        newUser.setNewBarcodeNumber(newBarcode);
        log.info("barcode : " + newBarcode);
        userRepository.save(newUser);
    }

    /**
     * 바코드 넘버 생성
     */
    public String generateBarcodeNumber(String id) {
        Random random = new Random();
        int length = id.length();
        String uniqueIdentifier;
        do {
        uniqueIdentifier =
                id.substring(0, length / 2)
                + random.ints(0, 10)
                        .limit(10-length)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining())
                + id.substring(length / 2, length);
        log.info("고유식별자 :" + uniqueIdentifier);
        } while (checkBarcodeNumberDuplicate(uniqueIdentifier));
        return "935012" + uniqueIdentifier;
    }

    /**
     * 바코드 넘버 중복 확인
     */
    @Override
    public boolean checkBarcodeNumberDuplicate(String barcodeNumber) {
        Optional<User> user = userRepository.findUserByBarcodeNumber(barcodeNumber);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * UUID 생성
     */
    @Override
    public String generateUUID() {
        String newUUID;
        do {
            newUUID = UUID.randomUUID().toString();
        } while (checkUuidDuplicate(newUUID));
        return newUUID;
    }

    /**
     * UUID 중복 확인
     */
    @Override
    public boolean checkUuidDuplicate(String UUID) {
        Optional<User> user = userRepository.findUserByUserUUID(UUID);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 회원 탈퇴
     */
    @Override
    public void deactivateAccount(AuthDeactivateSignUpDto deactivateDto, String uuid) {
        User user = getUserByUUID(uuid);
        String userPassword = deactivateDto.getUserPassword();
        if (validateUserPassword(userPassword, uuid)) {
            user.deactivateAccount(LocalDateTime.now());
            userRepository.save((user));
        } else {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다");
        }
    }


    /**
     * 패스워드 일치 검사
     */
    @Override
    public boolean validateUserPassword(String userPassword, String uuid) {
        User user = getUserByUUID(uuid);
        if (user.getUserPassword().equals(userPassword)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * uuid로 유저 조회
     */
    @Override
    public User getUserByUUID(String uuid) {
        User user = userRepository.findUserByUserUUID(uuid)
                .orElseThrow(() -> new NoSuchElementException("해당하는 유저가 없습니다"));
        return user;
    }
}
