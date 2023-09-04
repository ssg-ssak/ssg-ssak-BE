package ssgssak.ssgpointuser.domain.receipt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.receipt.entity.Receipt;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptGetResponseDto {
    private Receipt receipt;
}
