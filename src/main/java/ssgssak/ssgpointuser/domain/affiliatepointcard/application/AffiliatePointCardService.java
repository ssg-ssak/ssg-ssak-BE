package ssgssak.ssgpointuser.domain.affiliatepointcard.application;

import ssgssak.ssgpointuser.domain.affiliatepointcard.dto.AffiliatePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.affiliatepointcard.dto.AffiliatePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCardType;

public interface AffiliatePointCardService {

    // 1. 카드 등록
    void registerCard(AffiliatePointCardCreateRequestDto requestDto, String uuid);

    // 2. 카드 조회 : uuid와 type에 해당하는 카드 조회
    AffiliatePointCardGetResponseDto getCard(AffiliatePointCardType type, String uuid);
}
