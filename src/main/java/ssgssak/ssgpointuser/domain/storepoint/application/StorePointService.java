package ssgssak.ssgpointuser.domain.storepoint.application;

import ssgssak.ssgpointuser.domain.storepoint.dto.StorePointAddDto;
import ssgssak.ssgpointuser.domain.storepoint.entity.StorePoint;

public interface StorePointService {

    /**
     * 적립(가맹점) 포인트
     * 1. 스토어 포인트 생성
     * 2. 가맹점(스토어)로 적립
     */

    // 1. 스토어 포인트 생성
    StorePoint createStorePoint(StorePointAddDto addStoreDto);

    // 2. 가맹점(스토어)로 적립
    void addStorePoint(StorePointAddDto storeDto, String uuid);

}
