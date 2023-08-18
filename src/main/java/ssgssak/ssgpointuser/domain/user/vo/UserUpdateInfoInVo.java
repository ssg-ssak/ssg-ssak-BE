package ssgssak.ssgpointuser.domain.user.vo;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserUpdateInfoInVo {
    @NonNull
    private String userUUID;
    @NonNull
    private String address;
    private String email;
}