package ssgssak.ssgpointuser.domain.store.application;

import ssgssak.ssgpointuser.domain.store.dto.StoreGetRegionRequestDto;
import ssgssak.ssgpointuser.domain.store.dto.StoreGetRegionResponseDto;
import ssgssak.ssgpointuser.domain.store.dto.StoreRegisterFavoriteRequestDto;

public interface StoreService {

    // 1. 매장 지도로 검색하기 : 지도에 표시되는 위-경도의 경곗값을 전달받아서, 그 사이에 존재하는 매장만 넘겨줌


// 2. 매장 지역으로 검색하기 : 제휴사,시,군(구)를 넘겨받아서, 그 사이에 존재하는 매장만 넘겨줌
StoreGetRegionResponseDto getByRegion(StoreGetRegionRequestDto requestDto);

    // 3. 단골매장 등록하기 : 매장 id값과 uuid를 넘겨받아서 진행, store_id가 아닌 store 전체를 저장하는것임
    void registerFavorite(StoreRegisterFavoriteRequestDto requestDto, String uuid);
}
