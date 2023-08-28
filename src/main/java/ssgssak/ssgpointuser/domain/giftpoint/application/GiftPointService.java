package ssgssak.ssgpointuser.domain.giftpoint.application;

import ssgssak.ssgpointuser.domain.giftpoint.dto.*;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftPoint;

public interface GiftPointService {
    /**
     * 선물 포인트
     * 1. 선물 포인트 생성
     * 2. 포인트 선물하기
     * 3. 포인트 선물받기(수락)
     * 4. 포인트 선물받기(거절)
     * 5. 포인트 선물 대기리스트 조회
     * 6. 선물 포인트 조회
     */

    // 1. 선물 포인트 생성
    GiftPoint createGiftPoint(GiftPointRequestDto requestDto);

    // 2. 포인트 선물하기
    void giveGiftPoint(GiftPointRequestDto requestDto);

    // 3. 포인트 선물받기
    void acceptGiftPoint(GiftPointAcceptDto responseDto);

    // 4. 포인트 선물받기(거절)
    void refuseGiftPoint(GiftPointRefuseDto refuseDto);

    // 5. 포인트 선물 대기리스트 조회
    GiftPointWaitListDto getGiftWaitList(String uuid);

    // 6. 선물 포인트 조회(적립, 기간에 따라서)
    GiftPointGetResponseDto getGiftList(GiftPointGetRequestDto requestDto);
}
