package ssgssak.ssgpointuser.domain.offlinepointcard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.global.common.entity.BaseTimeEntity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OfflinePointCard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String cvc;

    @Column(nullable = false)
    private String franchiseeName;

    @Column(nullable = false)
    private String issuedStoreName;

    // 유저 이름, 생일, UUID는 null이 가능한 값으로, 추후에 인증을 통해서 설정하게된다
    @Column
    private String userName;

    @Column
    private String userBirth;

    @Column
    private String userUUID;


    /**
     * 오프라인 포인트카드
     * 1. 유저 이름, 생일 등록
     * 2. 유저 UUID 등록
     */

    // 1. 유저 이름, 생일 등록
    public void setUserInfo(String userName, String userBirth) {
        this.userName = userName;
        this.userBirth = userBirth;
    }

    // 2. 유저 UUID 등록
    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }


}
