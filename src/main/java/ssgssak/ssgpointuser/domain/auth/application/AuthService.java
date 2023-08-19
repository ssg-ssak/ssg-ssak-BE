package ssgssak.ssgpointuser.domain.auth.application;

import ssgssak.ssgpointuser.domain.auth.dto.AuthDeactivateSignUpDto;
import ssgssak.ssgpointuser.domain.auth.dto.AuthSignUpDto;
import ssgssak.ssgpointuser.domain.user.entity.User;

public interface AuthService {

    void signUp(AuthSignUpDto authSignUpDto);

    boolean checkBarcodeNumberDuplicate(String barcodeNumber);

    String generateBarcodeNumber();

    String generateUUID();

    boolean checkUuidDuplicate(String UUID);

    void deactivateAccount(AuthDeactivateSignUpDto deactivateDto, String uuid);

    boolean validateUserPassword(String userPassword, String uuid);

    User getUserByUUID(String uuid);
}
