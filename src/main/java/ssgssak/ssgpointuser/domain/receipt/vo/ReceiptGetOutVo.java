package ssgssak.ssgpointuser.domain.receipt.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.receipt.entity.Receipt;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptGetOutVo {
    private Receipt receipt;
}
