package ssgssak.ssgpointuser.domain.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetRegionDto {
    private String storeName;
    private String city;
    private String district;
    private String roadAddress;
    private Double longitude;
    private Double latitude;
    private GetFranchiseDto franchiseDto;
}
