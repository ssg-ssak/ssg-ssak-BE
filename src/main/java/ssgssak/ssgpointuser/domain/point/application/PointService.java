package ssgssak.ssgpointuser.domain.point.application;

import ssgssak.ssgpointuser.domain.point.dto.*;
import ssgssak.ssgpointuser.domain.user.entity.User;

public interface PointService {
    /**
     * 포인트
     * 1. 유저 조회
     * 2. 유저 기존 totalPoint 조회
     * 3. 포인트 사용/적립 계산
     * 4. 가맹점(스토어)로 적립
     * 5. 제휴사(파트너)로 적립
     * 6. 포인트 선물하기
     * 7. 포인트 선물받기
     * 8. 포인트 선물 대기리스트 조회
     * 9. 포인트 전환하기
     */

    User getUser(String uuid);

    Integer getTotalPoint(String uuid);

    Integer calcTotalPoint(Boolean used, Integer totalPoint, Integer updatePoint);

    void pointAddStore(PointAddStoreDto storeDto, String uuid);

    void pointAddPartner(PointAddPartnerDto partnerDto, String uuid);

    // 6. 포인트 선물하기/받기
    void giveGiftPoint(PointGiftRequestDto pointGiftDto);

    // 7. 포인트 선물받기
    void receiveGiftPoint(PointGiftResponseDto receiverUUID);

    // 8. 포인트 선물 대기 리스트 조회
    PointGiftWaitListDto getGiftWaitList(String uuid);

    // 9. 포인트 전환하기
    void pointExchange(PointExchangeDto exchangeDto, String uuid);
}
