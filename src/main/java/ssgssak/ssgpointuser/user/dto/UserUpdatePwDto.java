package ssgssak.ssgpointuser.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdatePwDto {
    private String uuid;
    private String password;
}
