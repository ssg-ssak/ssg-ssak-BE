package ssgssak.ssgpointuser.domain.store.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.store.dto.GetRegionDto;
import ssgssak.ssgpointuser.domain.store.entity.Store;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreGetRegionOutVo {
    private List regionDtos;
}
