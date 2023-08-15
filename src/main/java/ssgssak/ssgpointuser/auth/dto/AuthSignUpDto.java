package ssgssak.ssgpointuser.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.user.entity.User;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AuthSignUpDto {
    private String userId;
    private String userName;
    private String userPassword;
    private String phoneNumber;
    private String address;
    private String email;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

}
