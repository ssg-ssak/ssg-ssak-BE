package ssgssak.ssgpointuser.domain.point.application;

import ssgssak.ssgpointuser.domain.point.dto.PointAddPartnerDto;
import ssgssak.ssgpointuser.domain.point.dto.PointAddStoreDto;
import ssgssak.ssgpointuser.domain.user.entity.User;

import java.util.Optional;

public interface PointService {
    /**
     * 포인트
     * 1. 유저 조회
     * 2. 유저 기존 totalPoint 조회
     * 3. 포인트 사용/적립 계산
     * 4. 가맹점(스토어)로 적립
     * 5. 제휴사(파트너)로 적립
     */

    User getUser(String uuid);

    Integer getTotalPoint(String uuid);

    Integer calcTotalPoint(Boolean used, Integer totalPoint, Integer updatePoint);

    void pointAddStore(PointAddStoreDto storeDto, String uuid);

    void pointAddPartner(PointAddPartnerDto partnerDto, String uuid);


}
