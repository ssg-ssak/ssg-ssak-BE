package ssgssak.ssgpointuser.domain.affiliatepointcard.entity;

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
public class AffiliatePointCard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cardName;

    @Column
    private String issuer;

    @Column
    private String cardLastNumber;

    @Column
    private String userUUID;

}
