package ssgssak.ssgpointuser.domain.point.application;

import ssgssak.ssgpointuser.domain.point.dto.*;
import ssgssak.ssgpointuser.domain.point.entity.Point;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

import java.util.HashMap;
import java.util.List;

public interface PointService {
    /**
     * 포인트
     * 1. 유저 기존 totalPoint 조회
     * 2. 포인트 사용/적립 계산
     * 3. 포인트 생성
     * 4. 가맹점(스토어)로 적립
     * 5. 제휴사(파트너)로 적립
     * 6. 포인트 선물받기(수락) -> 포인트 2개 생성
     * 7. 포인트 전환하기
     * 8. 포인트 조회하기
     * 9. 사용가능 포인트 조회
     * 10. 기간별 적립한/사용한 포인트 계산
     * 11. 이벤트 포인트 적립
     * 12. 이벤트 당일 중복확인 (오늘 날짜로 조회해서 있다면 중복이다)
     * 13. 어제의 출석체크 유무 조회
     */


    // 1. 유저 기존 totalPoint 조회
    Integer getTotalPoint(String uuid);

    // 2. 포인트 사용/적립 계산
    Integer calcTotalPoint(Boolean used, Integer totalPoint, Integer updatePoint);

    // 3. 포인트 생성
    Point createPoint(CreatePointDto dto, String uuid);

    // 4. 가맹점(스토어)로 적립
    PointIdOutDto pointAdd(CreatePointDto pointDto, String uuid);

    // 6. 포인트 선물받기(수락) -> 포인트 생성
    PointGiftAcceptResponseDto receiveGiftPoint(PointGiftAcceptRequestDto requestDto, String receiverUUID);

    // 8. 포인트 조회하기
    PointListResponseDto pointSearch(PointListRequestDto requestDto, String uuid);

    // 9. 사용가능 포인트 조회
    PointPossibleResponseDto searchPossible(String uuid);

    // 10. 기간별 적립한/사용한 포인트 계산
    HashMap<String, Integer> calcAddUsedPoint(List<Point> pointList);

    // 11. 이벤트 포인트 적립
    PointEventOutDto pointAddEvent(CreatePointDto pointDto, String uuid, Integer continueDay);

    // 12. 이벤트 당일 중복확인 (오늘 날짜로 조회해서 있다면 중복이다)
    CheckDuplicateDto checkDuplicate(String uuid, PointType type);

    // 13. 어제의 출석체크 유무 조회
    Boolean yesterdayAttendance(String uuid);
}
