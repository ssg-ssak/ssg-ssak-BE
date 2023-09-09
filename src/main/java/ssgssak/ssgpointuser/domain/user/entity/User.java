package ssgssak.ssgpointuser.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ssgssak.ssgpointuser.global.common.entity.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table
@ToString
public class User extends BaseTimeEntity {
    // entity에 unique를 할 필요가 없음. 어차피 중복 검사해서 들어오는 값
    // DDD관점에서는 비즈니스 로직을 엔티티에 작성해도 괜찮음, 고려해볼것
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String userId;

    @Column(nullable = false, length = 100)
    private String userUUID;

    @Column(nullable = false, length = 20)
    private String userName;

    @Column(nullable = false, length = 300)
    private String userPassword;

    @Column(nullable = false, length = 11) // 휴대폰번호는 외부 api에서 진행할것
    private String phoneNumber;

    @Column(nullable = false, length = 300)
    private String address;

    @Column(length = 30) // email
    private String email;

    // regDate, updateDate는 baseEntity로 대체함
    @Column(length = 100)
    private String pointPassword;

    //바코드넘버 : 935012 + (String)userId의 절반은 앞에, 절반은 맨뒤에 + 가운데는 랜덤숫자 : 총 16숫자 todo: 유저에는 바코드 번호가 없다..!
    @Column(unique = true, nullable = false, length = 16)
    private String barcodeNumber;

    @Column
    private LocalDateTime softDelete;

    @Column
    @Enumerated(EnumType.STRING)
    private Roll roll;


    /**
     * 도메인 로직
     * 1. 회원정보 수정 : email, address 변경
     * 2. 비밀번호 변경 : userPassword 변경
     * 3. 포인트pw 변경 : pointPassword 변경
     * 4. 회원탈퇴 : softDelete 추가
     * 5. 바코드 설정
     * 6. 비밀번호 해싱
     * 7. 유저 Roll 설정
     */

    // 1. 회원정보 수정
    public void updateUserInfo(String email, String address) {
        this.email = email;
        this.address = address;
    }

    // 2. 비밀번호 변경
    public void updatePassword(String userPassword) {
        this.userPassword = userPassword;
    }

    // 3. 포인트 패스워드 변경
    public void updatePointPw(String pointPassword) {
        this.pointPassword = pointPassword;
    }

    // 4. 회원 탈퇴
    public void deactivateAccount(LocalDateTime softDelete){
        this.softDelete = softDelete;
    }

    // 5. 바코드 설정
    public void setNewBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    // 6. 비밀번호 해싱
    public void hashPassword(String userPassword) {
        this.userPassword = new BCryptPasswordEncoder().encode(userPassword);
    }

    // 7. 유저 Roll 설정
    @PostPersist
    public void setUserRoll() {
        this.roll = Roll.USER;
    }
}
