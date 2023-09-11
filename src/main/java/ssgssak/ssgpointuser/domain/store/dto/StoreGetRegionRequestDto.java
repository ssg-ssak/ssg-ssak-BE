package ssgssak.ssgpointuser.domain.store.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StoreGetRegionRequestDto {
    private String franchiseName;
    private String city;
    private String district;
}
