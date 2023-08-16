package ssgssak.ssgpointuser.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateInfoDto {
    private String userUUID;
    private String userPassword;
    private String address;
    private String email;
    private String pointPassword;
    private LocalDateTime updateDate;
}
