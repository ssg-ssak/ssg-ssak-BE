package ssgssak.ssgpointuser.domain.offlinepointcard.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardRegisterRequestDto;
import ssgssak.ssgpointuser.domain.offlinepointcard.entity.OfflinePointCard;
import ssgssak.ssgpointuser.domain.offlinepointcard.infrastructure.OfflinePointCardRepository;
import ssgssak.ssgpointuser.global.common.exception.NoSuchCardException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OfflinePointCardServiceImpl implements OfflinePointCardService{
    private final OfflinePointCardRepository offlinePointCardRepository;
    private final ModelMapper modelMapper;

    /**
     * 오프라인 포인트카드
     * 1. 임시카드 발급(생성)
     * 2. 임시카드 최종등록(업데이트)
     * 2. 카드 조회 : uuid에 해당하는 카드 모두 조회
     */

    // 1. 신규카드 등록(생성)
    @Override
    public void createCard(OfflinePointCardCreateRequestDto requestDto, String userUUID) {
        OfflinePointCard card = modelMapper.map(requestDto, OfflinePointCard.class);
        // 신규 카드 등록이라면 UUID도 설정해준다
        card.setUserUUID(userUUID);
        offlinePointCardRepository.save(card);
    }

    // 2. 임시카드 발급(생성) -> createCard를 오버로딩
    @Override
    public void createCard(OfflinePointCardCreateRequestDto requestDto) {
        OfflinePointCard card = modelMapper.map(requestDto, OfflinePointCard.class);
        // 임시 카드 발급이라면 UUID를 제외하고 생성한다
        offlinePointCardRepository.save(card);
    }

    // 2. 임시카드 최종등록(업데이트)
    @Override
    public void registerCard(OfflinePointCardRegisterRequestDto requestDto, String userUUID) {
        OfflinePointCard card = offlinePointCardRepository.findByCardNumber(requestDto.getCardNumber())
                .orElseThrow(()->new NoSuchCardException("입력하신 정보에 해당하는 임시 발급 카드가 존재하지 않습니다"));
        // 임시카드는 userName, userBirth, cvc가 이미 등록되어있다
        // -> 등록된 생년월일, 이름, cvc가 일치하는지 확인 후 UUID를 설정해준다
        if (card.getUserBirth() != requestDto.getUserBirth()
            || card.getUserName() != requestDto.getUserName()
            || card.getCvc() != requestDto.getCvc()) {
            throw new NoSuchCardException("입력하신 정보에 해당하는 임시 발급 카드가 존재하지 않습니다");
        }
        card.setUserUUID(userUUID);
    }

    // 3. 카드 조회
    @Override
    @Transactional(readOnly = true)
    public OfflinePointCardGetResponseDto getCardList(String uuid) {
        // 카드의 모든 정보를 담고있는 리스트
        List<OfflinePointCard> originList = offlinePointCardRepository.findAllByUserUUID(uuid);
        List offlinePointCardList = new ArrayList<>();
        // origin에서 카드 하나하나를 꺼낸 후, 카드번호 뒤에 4자리, 발급처, 생성일만 따로 저장해서 dto로 넘겨준다
        for (OfflinePointCard card : originList) {
            HashMap<String, String> data = new HashMap<>();
            data.put("cardNumber", card.getCardNumber());
            data.put("issuedStore", card.getIssuedStoreName());
            data.put("createAt", card.getCreateAt().toString());
            offlinePointCardList.add(data);
        }
        return OfflinePointCardGetResponseDto.builder().offlinePointCardList(offlinePointCardList).build();
    }
}
