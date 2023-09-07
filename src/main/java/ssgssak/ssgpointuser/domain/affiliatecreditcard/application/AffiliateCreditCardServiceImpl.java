package ssgssak.ssgpointuser.domain.affiliatecreditcard.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.dto.AffiliateCreditCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.dto.AffiliateCreditCardGetResponseDto;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.entity.AffiliateCreditCard;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.infrastructure.AffiliateCreditCardRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AffiliateCreditCardServiceImpl implements AffiliateCreditCardService{
    private final AffiliateCreditCardRepository affiliateCreditCardRepository;
    private final ModelMapper modelMapper;

    /**
     * 제휴신용카드
     * 1. 카드 등록
     * 2. 모든 카드 조회 : uuid에 해당하는 카드 모두 조회
     */

    // 1. 카드 등록
    @Override
    public void createCard(AffiliateCreditCardCreateRequestDto requestDto, String userUUID) {
        requestDto = requestDto.toBuilder().userUUID(userUUID).build();
        AffiliateCreditCard card = modelMapper.map(requestDto, AffiliateCreditCard.class);
        affiliateCreditCardRepository.save(card);
    }

    // 2. 모든 카드 조회
    @Override
    public AffiliateCreditCardGetResponseDto getCardList(String userUUID) {
        List<AffiliateCreditCard> cardList = affiliateCreditCardRepository.findAllByUserUUID(userUUID);
        List dataList = new ArrayList();
        HashMap<String, String> data = new HashMap<>();
        for (AffiliateCreditCard card : cardList) {
            data.put("cardName", card.getCardName());
            data.put("cardNumber", card.getCardNumber().substring(12));
            data.put("issuer", card.getIssuer().toString());
            data.put("createAt", card.getCreateAt().toString());
        }
        dataList.add(data);
        return AffiliateCreditCardGetResponseDto.builder()
                .cardDataList(dataList)
                .build();
    }
}
