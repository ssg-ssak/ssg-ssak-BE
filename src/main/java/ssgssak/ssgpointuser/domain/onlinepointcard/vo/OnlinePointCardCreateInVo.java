package ssgssak.ssgpointuser.domain.onlinepointcard.vo;

import lombok.Getter;
import lombok.ToString;
import ssgssak.ssgpointuser.domain.onlinepointcard.entity.OnlinePointCardIssuer;

@Getter
public class OnlinePointCardCreateInVo {
    private String cardNumber;
    private OnlinePointCardIssuer issuer;
    private String cvc;
}
