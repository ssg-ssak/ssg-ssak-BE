package ssgssak.ssgpointuser.domain.auth.vo;

import lombok.Getter;

@Getter
public class AuthGetLoginIdInVo {
    private String userName;
    private String phoneNumber;

    public AuthGetLoginIdInVo(String userName, String phoneNumber) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }
}
