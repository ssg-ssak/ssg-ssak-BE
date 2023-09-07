package ssgssak.ssgpointuser.domain.affiliatepointcard.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.infrastructure.AffiliateCreditCardRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AffiliatePointCardServiceImpl implements AffiliatePointCardService{
    private final AffiliateCreditCardRepository affiliateCreditCardRepository;
    private final ModelMapper modelMapper;

    /**
     * 온라인 포인트카드
     * 1. 카드 등록
     * 2. 카드 조회 : uuid에 해당하는 카드 모두 조회
     */


}
