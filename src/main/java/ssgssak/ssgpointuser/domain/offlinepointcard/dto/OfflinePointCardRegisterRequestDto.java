package ssgssak.ssgpointuser.domain.offlinepointcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfflinePointCardRegisterRequestDto {
    private String cardNumber;
    private String cvc;

    // null이어도 됨
    private String userName;
    private String userBirth;
    private String franchiseeName;
    private String issuedStoreName;
}
