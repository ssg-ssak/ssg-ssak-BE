package ssgssak.ssgpointuser.domain.auth.vo;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class AuthSignUpVo {
    private String userId;
    private String userName;
    private String userPassword;
    private String phoneNumber;
    private String address;
    private String email;
}
