package ssgssak.ssgpointuser.domain.affiliatepointcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCardType;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AffiliatePointCardCreateRequestDto {
    private String cardNumber;
    private AffiliatePointCardType type;
    private String engName;
    // null로 들어와야함
    private String userUUID;
}
