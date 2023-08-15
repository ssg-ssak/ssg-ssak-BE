package ssgssak.ssgpointuser.auth.application;

import org.springframework.stereotype.Component;
import ssgssak.ssgpointuser.auth.dto.AuthSignUpDto;
import ssgssak.ssgpointuser.auth.vo.AuthSignUpVo;
import ssgssak.ssgpointuser.user.entity.User;

import java.time.LocalDateTime;

@Component
public class AuthConverter {

    /**
     * SignUp Vo를 Dto로
     */
    public AuthSignUpDto signUpVoToDto(AuthSignUpVo authSignUpVo) {
        return AuthSignUpDto.builder()
                .userId(authSignUpVo.getUserId())
                .userName(authSignUpVo.getUserName())
                .userPassword(authSignUpVo.getUserPassword())
                .phoneNumber(authSignUpVo.getPhoneNumber())
                .address(authSignUpVo.getAddress())
                .email(authSignUpVo.getEmail())
                .regDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }


    /**
     * SignUp Dto를 Entity로
     */
    public User signUpDtoToEntity(AuthSignUpDto authSignUpDto, String barcodeNumber) {
        return User.builder()
                .userId(authSignUpDto.getUserId())
                .userName(authSignUpDto.getUserName())
                .userPassword(authSignUpDto.getUserPassword())
                .phoneNumber(authSignUpDto.getPhoneNumber())
                .address(authSignUpDto.getAddress())
                .email(authSignUpDto.getEmail())
                .barcodeNumber(barcodeNumber)
                .regDate(authSignUpDto.getRegDate())
                .updateDate(authSignUpDto.getUpdateDate())
                .build();
    }

}
