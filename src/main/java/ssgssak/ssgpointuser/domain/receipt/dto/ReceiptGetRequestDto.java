package ssgssak.ssgpointuser.domain.receipt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptGetRequestDto {
    private Long receiptId;
}
