package ssgssak.ssgpointuser.auth.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AuthSignUpVo {
    private String userId;
    private String userName;
    private String userPassword;
    private String phoneNumber;
    private String address;
    private String email;
}
