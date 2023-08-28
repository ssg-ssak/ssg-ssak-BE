package ssgssak.ssgpointuser.domain.partnerpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerPointAddDto {
    private Long pointId;
    private PartnerType type;
}
