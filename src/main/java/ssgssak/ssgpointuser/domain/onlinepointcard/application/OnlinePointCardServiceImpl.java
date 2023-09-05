package ssgssak.ssgpointuser.domain.onlinepointcard.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.entity.OnlinePointCard;
import ssgssak.ssgpointuser.domain.onlinepointcard.infrastructure.OnlinePointCardRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OnlinePointCardServiceImpl implements OnlinePointCardService {
    private final OnlinePointCardRepository onlinePointCardRepository;
    private final ModelMapper modelMapper;

    /**
     * 온라인 포인트카드
     * 1. 카드 등록
     * 2. 카드 조회 : uuid에 해당하는 카드 모두 조회
     */

    // 1. 카드 등록
    @Override
    public void createCard(OnlinePointCardCreateRequestDto requestDto, String uuid) {
        requestDto = requestDto.toBuilder().userUUID(uuid).build();
        OnlinePointCard card = modelMapper.map(requestDto, OnlinePointCard.class);
        onlinePointCardRepository.save(card);
    }

    // 2. 카드 조회
    @Override
    public OnlinePointCardGetResponseDto getCardList(String uuid) {
        // 카드의 모든 정보를 담고있는 리스트
        List<OnlinePointCard> originList = onlinePointCardRepository.findAllByUserUUID(uuid);
        List onlinePointCardList = new ArrayList<>();
        // origin에서 카드 하나하나를 꺼낸 후, 카드번호, 발급처, 생성일만 따로 저장해서 dto로 넘겨준다
        for (OnlinePointCard card : originList) {
            HashMap<String, String> data = new HashMap<>();
            data.put("cardNumber", card.getCardNumber());
            data.put("issuer", card.getIssuer());
            data.put("createAt", card.getCreateAt().toString());
            onlinePointCardList.add(data);
        }
        return OnlinePointCardGetResponseDto.builder().onlinePointCardList(onlinePointCardList).build();
    }

}
