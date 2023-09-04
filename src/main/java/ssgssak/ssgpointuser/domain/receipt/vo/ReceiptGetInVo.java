package ssgssak.ssgpointuser.domain.receipt.vo;

import lombok.Getter;

@Getter
public class ReceiptGetInVo {
    private Long receiptId;

    public ReceiptGetInVo(Long receiptId) {
        this.receiptId = receiptId;
    }
}
