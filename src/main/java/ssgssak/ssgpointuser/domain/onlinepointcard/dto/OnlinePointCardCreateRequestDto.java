package ssgssak.ssgpointuser.domain.onlinepointcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OnlinePointCardCreateRequestDto {
    private String cardNumber;
    private String issuer;
    private String cvc;
    private String userUUID;
}
