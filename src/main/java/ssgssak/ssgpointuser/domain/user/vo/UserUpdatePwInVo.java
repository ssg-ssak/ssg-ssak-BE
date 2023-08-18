package ssgssak.ssgpointuser.domain.user.vo;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserUpdatePwInVo {
    @NonNull
    private String password;
    @NonNull
    private String uuid;
}
