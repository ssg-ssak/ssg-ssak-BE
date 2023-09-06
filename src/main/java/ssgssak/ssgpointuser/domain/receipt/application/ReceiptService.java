package ssgssak.ssgpointuser.domain.receipt.application;

import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetResponseDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveResponseDto;

public interface ReceiptService {
    /**
     * 영수증
     * 1. 영수증 저장
     * 2. 영수증 id로, 영수증 조회
     * 3. 영수증 번호로, 영수증 조회
     */

    // 1. 영수증 저장
    ReceiptSaveResponseDto saveReceipt(ReceiptSaveRequestDto requestDto);

    // 2. 영수증 id로, 영수증 조회
    ReceiptGetResponseDto getReceiptById(Long receiptId);

    // 3. 영수증 번호로, 영수증 조회
    @Transactional(readOnly = true)
    ReceiptGetResponseDto getReceiptByNumber(String receiptNumber);
}
