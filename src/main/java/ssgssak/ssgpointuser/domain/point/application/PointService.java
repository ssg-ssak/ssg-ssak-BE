package ssgssak.ssgpointuser.domain.point.application;

import ssgssak.ssgpointuser.domain.point.dto.*;
import ssgssak.ssgpointuser.domain.point.entity.Point;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

import java.time.LocalDateTime;
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
     */


    // 1. 유저 기존 totalPoint 조회
    Integer getTotalPoint(String uuid);

    // 2. 포인트 사용/적립 계산
    Integer calcTotalPoint(Boolean used, Integer totalPoint, Integer updatePoint);

    // 3. 포인트 생성
    Point createPoint(CreatePointDto dto, String uuid);

    // 4. 가맹점(스토어)로 적립 //todo: 모든 적립 vo를 createPoint dto로 바꾸면됨
    PointIdOutDto pointAddStore(CreatePointDto pointDto, String uuid);

    // 5. 제휴사(파트너)로 적립
    PointIdOutDto pointAddPartner(CreatePointDto pointDto, String uuid);

    // 6. 포인트 선물받기(수락) -> 포인트 생성
    PointGiftAcceptResponseDto receiveGiftPoint(PointGiftAcceptRequestDto requestDto);

    // 7. 포인트 전환하기
    PointIdOutDto pointExchange(CreatePointDto pointDto, String uuid);

    // 8. 포인트 조회하기
    PointListResponseDto pointSearch(PointListRequestDto requestDto, String uuid);

    // 9. 사용가능 포인트 조회
    PointPossibleResponseDto searchPossible(String uuid);

    // 10. 기간별 적립한/사용한 포인트 계산
    HashMap<String, Integer> calcAddUsedPoint(List<Point> pointList);
}
