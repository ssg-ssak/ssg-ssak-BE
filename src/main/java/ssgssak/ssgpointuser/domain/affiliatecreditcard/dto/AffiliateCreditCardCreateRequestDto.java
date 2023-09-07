package ssgssak.ssgpointuser.domain.affiliatecreditcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.entity.AffiliateCreditCardIssuer;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCardType;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateCreditCardCreateRequestDto {
    private AffiliateCreditCardIssuer issuer;
    private String cardName;
    private String cardNumber;
    private String userUUID;
}
