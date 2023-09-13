package ssgssak.ssgpointuser.domain.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGetOutVo {
    private String userName;
    private String userBarcodeNumber;
}
