package ssgssak.ssgpointuser.domain.franchise.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.franchise.entity.Franchise;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FranchiseGetOutVo {
    private List<Franchise> franchiseList;
}
