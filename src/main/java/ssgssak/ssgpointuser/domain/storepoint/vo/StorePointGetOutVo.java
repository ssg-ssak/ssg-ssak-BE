package ssgssak.ssgpointuser.domain.storepoint.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.storepoint.entity.StorePoint;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorePointGetOutVo {
    private StorePoint storePoint;
}
