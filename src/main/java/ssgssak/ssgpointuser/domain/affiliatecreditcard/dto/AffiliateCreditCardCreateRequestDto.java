package ssgssak.ssgpointuser.domain.affiliatecreditcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.entity.AffiliateCreditCardType;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateCreditCardCreateRequestDto {
    private String cardNumber;
    private String engName;
    private String userUUID;
    private AffiliateCreditCardType type;
}
