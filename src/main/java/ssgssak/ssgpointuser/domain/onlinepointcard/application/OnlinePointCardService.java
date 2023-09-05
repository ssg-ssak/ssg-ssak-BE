package ssgssak.ssgpointuser.domain.onlinepointcard.application;

import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardGetResponseDto;

public interface OnlinePointCardService {

    // 1. 카드 등록
    void createCard(OnlinePointCardCreateRequestDto requestDto, String uuid);

    // 2. 카드 조회
    OnlinePointCardGetResponseDto getCardList(String uuid);
    /**
     * 온라인 포인트카드
     */
}
