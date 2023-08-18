package ssgssak.ssgpointuser.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@AllArgsConstructor
@NonNull
@Getter
public class AuthDeactivateSignUpDto {
    String userPassword;
}
