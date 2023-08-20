package ssgssak.ssgpointuser.domain.auth.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuthDeactivateSignUpDto {
    String userPassword;
}
