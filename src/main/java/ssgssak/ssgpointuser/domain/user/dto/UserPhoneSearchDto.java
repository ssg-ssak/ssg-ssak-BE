package ssgssak.ssgpointuser.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPhoneSearchDto {
    private String userName;
    private String userId;
    private String receiverUUID;
}
