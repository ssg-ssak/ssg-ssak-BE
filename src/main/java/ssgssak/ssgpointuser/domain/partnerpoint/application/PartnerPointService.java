package ssgssak.ssgpointuser.domain.partnerpoint.application;

import ssgssak.ssgpointuser.domain.partnerpoint.dto.PartnerPointAddDto;
import ssgssak.ssgpointuser.domain.partnerpoint.entity.PartnerPoint;

public interface PartnerPointService {
    /**
     * 제휴(카드) 포인트
     * 1. 제휴 포인트 생성
     * 2. 제휴(카드)로 적립
     */

    // 1. 제휴 포인트 생성
    PartnerPoint createPartnerPoint(PartnerPointAddDto addPartnerDto);

    // 2. 제휴(카드)로 적립
    void addPartnerPoint(PartnerPointAddDto partnerDto, String uuid);

}
