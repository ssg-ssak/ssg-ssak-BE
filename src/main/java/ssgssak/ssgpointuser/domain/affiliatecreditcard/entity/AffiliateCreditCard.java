package ssgssak.ssgpointuser.domain.affiliatecreditcard.entity;

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
public class AffiliateCreditCard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private AffiliateCreditCardIssuer issuer;

    @Column(nullable = false)
    private String cardName;

    @Column
    private String cardNumber;

    @Column
    private String userUUID;
}
