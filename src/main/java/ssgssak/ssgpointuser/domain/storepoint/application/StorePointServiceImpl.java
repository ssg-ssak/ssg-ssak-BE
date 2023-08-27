package ssgssak.ssgpointuser.domain.storepoint.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.storepoint.dto.StorePointAddDto;
import ssgssak.ssgpointuser.domain.storepoint.entity.StorePoint;
import ssgssak.ssgpointuser.domain.storepoint.infrastructure.StorePointRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class StorePointServiceImpl implements StorePointService{
    private final ModelMapper modelMapper;
    private final StorePointRepository storePointRepository;

    /**
     * 결제(가맹점) 적립
     * 1. 스토어 포인트 생성
     * 2. 가맹점(스토어)로 적립
     */

    // 1. 스토어 포인트 생성
    @Override
    public StorePoint createStorePoint(StorePointAddDto addStoreDto) {
        StorePoint storePoint = modelMapper.map(addStoreDto, StorePoint.class);
        return storePoint;
    }

    // 2. 가맹점(스토어)로 적립
    @Override
    public void addStorePoint(StorePointAddDto storeDto, String uuid) {
        storePointRepository.save(createStorePoint(storeDto));
    }
}
