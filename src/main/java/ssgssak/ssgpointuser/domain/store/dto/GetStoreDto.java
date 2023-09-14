package ssgssak.ssgpointuser.domain.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetStoreDto {
    private Long storeId;
    private String storeName;
    private Long franchise_id;
    private String city;
    private String district;
    private String roadAddress;
    private Double latitude;
    private Double longitude;
}
