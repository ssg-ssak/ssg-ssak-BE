package ssgssak.ssgpointuser.domain.storepoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorePointAddDto {
    private Long pointId;
    private Long receiptId;
    private Long storeId;
}
