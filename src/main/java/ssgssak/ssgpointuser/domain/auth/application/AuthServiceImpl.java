package ssgssak.ssgpointuser.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.auth.dto.AuthSignUpDto;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    /**
     * 회원가입
     */
    public void signUp(AuthSignUpDto authSignUpDto) {
        String newBarcode = generateBarcodeNumber();
        String newUUID = generateUUID();
        User newUser = User.builder()
                .userId(authSignUpDto.getUserId())
                .userUUID(newUUID)
                .userName(authSignUpDto.getUserName())
                .userPassword(authSignUpDto.getUserPassword())
                .email(authSignUpDto.getEmail())
                .address(authSignUpDto.getAddress())
                .phoneNumber(authSignUpDto.getPhoneNumber())
                .barcodeNumber(newBarcode)
                .build();
        userRepository.save(newUser);
    }

    /**
     * 바코드 넘버 생성
     */
    public String generateBarcodeNumber() {
        Random random = new Random();
        String number;
        do {
            number = random.ints(0,10)
                    .limit(16)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining());
        } while (checkBarcodeNumberDuplicate(number));
        return number;
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

//    /**
//     * 회원 탈퇴
//     */
//    @Override
//    public void deactivateAccount(AuthDeactivateSignUpDto deactivateDto, String uuid) {
//        User user = userService.getUserByUUID(uuid);
//        if (validateUserPassword(deactivateDto.getUserPassword(), uuid)) {
//
//        }
//    }
//
//    /**
//     * 패스워드 일치 검사
//     */
//    @Override
//    public boolean validateUserPassword(String userPassword, String uuid) {
//        User user = userService.getUserByUUID(uuid);
//        if (user.getUserPassword().equals(userPassword)) {
//            return true;
//        } else {
//            return false;
//        }
//    }


}
