package ssgssak.ssgpointuser.domain.partnerpoint.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.partnerpoint.dto.PartnerType;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PartnerPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private PartnerType type;

    @Column(nullable = false)
    private Long pointId;

}
