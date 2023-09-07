package ssgssak.ssgpointuser.domain.affiliatecreditcard.vo;

import lombok.Getter;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.entity.AffiliateCreditCardIssuer;

@Getter
public class AffiliateCreditCardRegisterInVo {
    private AffiliateCreditCardIssuer issuer;
    private String cardName;
    private String cardNumber;
}
