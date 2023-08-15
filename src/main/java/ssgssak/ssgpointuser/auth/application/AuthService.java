package ssgssak.ssgpointuser.auth.application;

import ssgssak.ssgpointuser.auth.dto.AuthSignUpDto;

public interface AuthService {

    void signUp(AuthSignUpDto authSignUpDto);

    boolean checkBarcodeNumberDuplicate(String barcodeNumber);

    String generateBarcodeNumber();
}
