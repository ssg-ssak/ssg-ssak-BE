package ssgssak.ssgpointuser.domain.franchise.dto;

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
public class FranchiseGetResponseDto {
    private List<Franchise> franchiseList;
}
