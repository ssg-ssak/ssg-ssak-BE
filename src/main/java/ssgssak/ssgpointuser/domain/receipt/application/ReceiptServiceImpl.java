package ssgssak.ssgpointuser.domain.receipt.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetResponseDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveResponseDto;
import ssgssak.ssgpointuser.domain.receipt.entity.Receipt;
import ssgssak.ssgpointuser.domain.receipt.infrastructure.ReceiptRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    /**
     * 영수증
     * 1. 영수증 저장
     * 2. 영수증 id로, 영수증 조회
     */

    // 1. 영수증 저장
    @Override
    public ReceiptSaveResponseDto saveReceipt(ReceiptSaveRequestDto requestDto) {
        Receipt receipt = Receipt.builder().receiptNumber(requestDto.getReceiptNumber()).build();
        receiptRepository.save(receipt);
        return ReceiptSaveResponseDto.builder().receiptId(receipt.getId()).build();
    }

    // 2. 영수증 id로, 영수증 조회
    @Override
    @Transactional(readOnly = true)
    public ReceiptGetResponseDto getReceiptById(Long receiptId) {
        Receipt receipt = receiptRepository.findById(receiptId)
                .orElseThrow(() -> new NoSuchElementException());
        return ReceiptGetResponseDto.builder().receipt(receipt).build();
    }

    // 3. 영수증 번호로, 영수증 조회
    @Override
    @Transactional(readOnly = true)
    public ReceiptGetResponseDto getReceiptByNumber(String receiptNumber) {
        Receipt receipt = receiptRepository.findByReceiptNumber(receiptNumber)
                .orElseThrow(() -> new NoSuchElementException());
        return ReceiptGetResponseDto.builder().receipt(receipt).build();
    }
}
