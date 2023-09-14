package ssgssak.ssgpointuser.domain.store.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.store.dto.GetStoreDto;
import ssgssak.ssgpointuser.domain.store.entity.Store;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreGetIdOutVo {
    private GetStoreDto storeDto;
}
