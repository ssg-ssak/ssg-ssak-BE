package ssgssak.ssgpointuser.domain.onlinepointcard.entity;

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
public class OnlinePointCard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cardNumber;

    @Column
    private String cvc;

    @Enumerated(EnumType.STRING)
    private OnlinePointCardIssuer issuer;

    @Column
    private String userUUID;
}
