package ssgssak.ssgpointuser.domain.auth.dto;

import lombok.*;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AuthSignUpDto {
    private String userId;
    private String userName;
    private String userPassword;
    private String phoneNumber;
    private String address;
    private String email;

}
