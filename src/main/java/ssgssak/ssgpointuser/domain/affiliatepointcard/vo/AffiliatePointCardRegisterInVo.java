package ssgssak.ssgpointuser.domain.affiliatepointcard.vo;


import lombok.Getter;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCardType;

@Getter
public class AffiliatePointCardRegisterInVo {
    private String cardNumber;
    private AffiliatePointCardType type;
    // null이어도 됨 -> 대한항공에서만 사용함
    private String engName;
}
