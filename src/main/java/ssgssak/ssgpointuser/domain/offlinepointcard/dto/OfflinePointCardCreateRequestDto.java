package ssgssak.ssgpointuser.domain.offlinepointcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OfflinePointCardCreateRequestDto {
    private String cardNumber;
    private String cvc;
    private String franchiseeName;
    private String issuedStoreName;
    // 아래의 두 값은 null이어도 됨
    private String userName;
    private String userBirth;
}
