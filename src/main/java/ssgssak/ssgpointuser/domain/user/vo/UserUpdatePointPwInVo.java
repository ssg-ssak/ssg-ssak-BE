package ssgssak.ssgpointuser.domain.user.vo;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserUpdatePointPwInVo {
    private String uuid;
    @NonNull
    private String pointPassword;
}
