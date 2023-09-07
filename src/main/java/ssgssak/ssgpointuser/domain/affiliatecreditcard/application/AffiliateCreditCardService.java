package ssgssak.ssgpointuser.domain.affiliatecreditcard.application;

import ssgssak.ssgpointuser.domain.affiliatecreditcard.dto.AffiliateCreditCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.dto.AffiliateCreditCardGetResponseDto;

public interface AffiliateCreditCardService {

    void createCard(AffiliateCreditCardCreateRequestDto requestDto, String userUUID);

    // 2. 모든 카드 조회
    AffiliateCreditCardGetResponseDto getCardList(String userUUID);
}
