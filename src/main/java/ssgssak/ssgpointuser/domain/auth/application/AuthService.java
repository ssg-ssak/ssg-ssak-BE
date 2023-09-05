package ssgssak.ssgpointuser.domain.auth.application;

import ssgssak.ssgpointuser.domain.auth.dto.*;
import ssgssak.ssgpointuser.domain.user.entity.User;

public interface AuthService {

    // 1. 로그인
    AuthLoginResponseDto userLogin(AuthLoginRequestDto requestDto);

    void signUp(AuthSignUpDto authSignUpDto);

    boolean checkBarcodeNumberDuplicate(String barcodeNumber);

    String generateBarcodeNumber(String id);

    String generateUUID();

    boolean checkUuidDuplicate(String UUID);

    void deactivateAccount(AuthDeactivateSignUpDto deactivateDto, String uuid);

    boolean validateUserPassword(String userPassword, String uuid);

    User getUserByUUID(String uuid);

    // 10. 유저 이름, 휴대폰 번호로 유저 Login Id 조회
    AuthGetLoginIdResponseDto getLoginId(AuthGetLoginIdRequestDto requestDto);
}
