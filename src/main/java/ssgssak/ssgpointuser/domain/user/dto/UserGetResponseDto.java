package ssgssak.ssgpointuser.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGetResponseDto {
    private String userName;
    private String userBarcodeNumber;
}
