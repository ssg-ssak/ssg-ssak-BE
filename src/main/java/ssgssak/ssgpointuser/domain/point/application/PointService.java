package ssgssak.ssgpointuser.domain.point.application;

import ssgssak.ssgpointuser.domain.point.dto.*;
import ssgssak.ssgpointuser.domain.point.entity.Point;
import ssgssak.ssgpointuser.domain.point.entity.PointType;
import ssgssak.ssgpointuser.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

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
     * 10. 포인트 조회하기
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

    // 10. 포인트 조회하기
    PointListResponseDto pointSearch(PointType type,
                                     Boolean used,
                                     String startDay,
                                     String endDay,
                                     String uuid);

    // 11. 날짜 변환
    LocalDateTime changeDate(String date);

    // 12. 사용가능 포인트 조회
    PointPossibleResponseDto searchPossible(String uuid);

    // 13. 기간별 적립한/사용한 포인트 계산
    HashMap<String, Integer> calcAddUsedPoint(List<Point> pointList);
}
