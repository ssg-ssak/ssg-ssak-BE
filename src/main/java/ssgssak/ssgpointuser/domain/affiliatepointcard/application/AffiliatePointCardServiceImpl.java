package ssgssak.ssgpointuser.domain.affiliatepointcard.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.affiliatepointcard.dto.AffiliatePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.affiliatepointcard.dto.AffiliatePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCard;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCardType;
import ssgssak.ssgpointuser.domain.affiliatepointcard.infrastructure.AffiliatePointCardRepository;
import ssgssak.ssgpointuser.global.common.exception.NoSuchCardException;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Transactional
public class AffiliatePointCardServiceImpl implements AffiliatePointCardService{
    private final AffiliatePointCardRepository affiliatePointCardRepository;
    private final ModelMapper modelMapper;

    /**
     * 온라인 포인트카드
     * 1. 카드 등록
     * 2. 카드 조회 : uuid와 type에 해당하는 카드 조회
     */

    // 1. 카드 등록
    @Override
    public void registerCard(AffiliatePointCardCreateRequestDto requestDto, String uuid) {
        requestDto = requestDto.toBuilder().userUUID(uuid).build();
        AffiliatePointCard card = modelMapper.map(requestDto, AffiliatePointCard.class);
        affiliatePointCardRepository.save(card);
    }

    // 2. 카드 조회 : uuid와 type에 해당하는 카드 조회
    @Override
    public AffiliatePointCardGetResponseDto getCard(AffiliatePointCardType type, String uuid) {
        AffiliatePointCard card = affiliatePointCardRepository.findByUserUUIDAndType(uuid, type)
                .orElseThrow(()-> new NoSuchCardException("입력하신 정보에 해당하는 카드가 존재하지 않습니다"));
        HashMap<String, String> data = new HashMap<>();
        data.put("type", card.getType().getName());
        data.put("cardNumber", card.getCardNumber());
        return AffiliatePointCardGetResponseDto.builder().card(data).build();
    }
}
