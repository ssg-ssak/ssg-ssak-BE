package ssgssak.ssgpointuser.domain.offlinepointcard.application;

import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardRegisterRequestDto;

public interface OfflinePointCardService {

    // 1. 임시카드 발급(생성)
    void createCard(OfflinePointCardCreateRequestDto requestDto, String userUUID);

    // 2. 임시카드 발급(생성)
    void createCard(OfflinePointCardCreateRequestDto requestDto);

    // 3. 임시카드 최종등록(업데이트)
    void registerCard(OfflinePointCardRegisterRequestDto requestDto, String userUUID);

    // 4. 카드 조회
    @Transactional(readOnly = true)
    OfflinePointCardGetResponseDto getCardList(String uuid);
}
