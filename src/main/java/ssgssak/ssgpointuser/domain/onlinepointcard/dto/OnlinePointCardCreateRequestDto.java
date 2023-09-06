package ssgssak.ssgpointuser.domain.onlinepointcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.onlinepointcard.entity.OnlinePointCardIssuer;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OnlinePointCardCreateRequestDto {
    private String cardNumber;
    private OnlinePointCardIssuer issuer;
    private String cvc;
    private String userUUID;
}
