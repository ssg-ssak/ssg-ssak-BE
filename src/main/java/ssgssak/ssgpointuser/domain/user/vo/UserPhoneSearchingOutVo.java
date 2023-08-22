package ssgssak.ssgpointuser.domain.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserPhoneSearchingOutVo {
    private String receiverUUID;
    private String userName;
    private String userId;
}
