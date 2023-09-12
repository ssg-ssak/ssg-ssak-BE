package ssgssak.ssgpointuser.domain.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreGetMapRequestDto {
    private Double upLatitude;
    private Double downLatitude;
    private Double leftLongitude;
    private Double rightLongitude;
}
