package ssgssak.ssgpointuser.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.auth.dto.AuthSignUpDto;
import ssgssak.ssgpointuser.user.entity.User;
import ssgssak.ssgpointuser.user.infrastructure.UserRepository;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthConverter authConverter;

    /**
     * 회원가입
     */
    public void signUp(AuthSignUpDto authSignUpDto) {
        String newBarcode = generateBarcodeNumber();
        User newUser = authConverter.signUpDtoToEntity(authSignUpDto, newBarcode);
        userRepository.save(newUser);
    }

    /**
     * 바코드 넘버 생성
     */
    public String generateBarcodeNumber() {
        Random random = new Random();
        String number = random.ints(0,10)
                .limit(16)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
        if (checkBarcodeNumberDuplicate(number) == false) {
            generateBarcodeNumber();
        }
        return number;
    }

    /**
     * 바코드 넘버 중복 확인
     */
    @Override
    public boolean checkBarcodeNumberDuplicate(String barcodeNumber) {
        Optional<User> user = userRepository.findUserByBarcodeNumber(barcodeNumber);
        if (user.isPresent()) {
            return false;
        } else {
            return true;
        }
    }
}
