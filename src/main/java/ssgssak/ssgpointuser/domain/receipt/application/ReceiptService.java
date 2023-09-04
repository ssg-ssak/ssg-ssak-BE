package ssgssak.ssgpointuser.domain.receipt.application;

import org.springframework.data.jpa.repository.JpaRepository;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetResponseDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveResponseDto;
import ssgssak.ssgpointuser.domain.receipt.entity.Receipt;

import java.util.List;

public interface ReceiptService {
    /**
     * 영수증
     * 1. 영수증 저장
     * 2. 영수증 id로, 영수증 조회
     */

    // 1. 영수증 저장
    ReceiptSaveResponseDto saveReceipt(ReceiptSaveRequestDto requestDto);

    // 2. 영수증 id로, 영수증 조회
    ReceiptGetResponseDto getReceipt(ReceiptGetRequestDto requestDto);

}
