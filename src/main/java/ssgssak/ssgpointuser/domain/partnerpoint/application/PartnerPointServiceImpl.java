package ssgssak.ssgpointuser.domain.partnerpoint.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.partnerpoint.dto.PartnerPointAddDto;
import ssgssak.ssgpointuser.domain.partnerpoint.entity.PartnerPoint;
import ssgssak.ssgpointuser.domain.partnerpoint.infrastructure.PartnerPointRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class PartnerPointServiceImpl implements PartnerPointService{

    private final PartnerPointRepository partnerPointRepository;
    private final ModelMapper modelMapper;

    /**
     * 제휴(카드) 포인트
     * 1. 제휴 포인트 생성
     * 2. 제휴(카드)로 적립
     */

    // 1. 제휴 포인트 생성
    @Override
    public PartnerPoint createPartnerPoint(PartnerPointAddDto addPartnerDto) {
        PartnerPoint partnerPoint = modelMapper.map(addPartnerDto, PartnerPoint.class);
        return partnerPoint;
    }

    // 2. 제휴(카드)로 적립
    @Override
    public void addPartnerPoint(PartnerPointAddDto partnerDto, String uuid) {
        partnerPointRepository.save(createPartnerPoint(partnerDto));
    }
}
