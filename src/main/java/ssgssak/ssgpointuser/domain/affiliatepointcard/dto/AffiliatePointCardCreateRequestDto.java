package ssgssak.ssgpointuser.domain.affiliatepointcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AffiliatePointCardCreateRequestDto {
    private String cardName;
    private String cardNumber;
    private String issuer;
    private Long storeId;
    private String userUUID;
}
