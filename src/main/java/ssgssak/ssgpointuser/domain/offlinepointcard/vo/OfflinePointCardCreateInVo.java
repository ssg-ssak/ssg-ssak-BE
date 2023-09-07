package ssgssak.ssgpointuser.domain.offlinepointcard.vo;

import lombok.Getter;

@Getter
public class OfflinePointCardCreateInVo {
    private String cardNumber;
    private String cvc;
    private String franchiseeName;
    private String issuedStoreName;
    // 아래의 두 값은 null이어도 됨
    private String userName;
    private String userBirth;
}
