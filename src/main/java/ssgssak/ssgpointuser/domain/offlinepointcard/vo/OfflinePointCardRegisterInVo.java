package ssgssak.ssgpointuser.domain.offlinepointcard.vo;

import lombok.Getter;

@Getter
public class OfflinePointCardRegisterInVo {
    private String cardNumber;
    private String cvc;

    // null이어도 됨
    private String userName;
    private String userBirth;
    private String franchiseeName;
    private String issuedStoreName;
}
