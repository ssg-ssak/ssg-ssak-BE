package ssgssak.ssgpointuser.domain.partnerpoint.vo;

import lombok.Getter;
import ssgssak.ssgpointuser.domain.partnerpoint.dto.PartnerType;

@Getter
public class PartnerPointAddInVo {
    private String uuid;
    private Long pointId;
    private PartnerType type;
}
