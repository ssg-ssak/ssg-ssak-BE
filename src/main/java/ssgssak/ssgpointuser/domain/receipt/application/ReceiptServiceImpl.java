package ssgssak.ssgpointuser.domain.receipt.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetResponseDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveRequestDto;
import ssgssak.ssgpointuser.domain.receipt.entity.Receipt;
import ssgssak.ssgpointuser.domain.receipt.infrastructure.ReceiptRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService{

    private final ReceiptRepository receiptRepository;

    /**
     * 영수증
     * 1. 영수증 저장
     * 2. 영수증 id로, 영수증 조회
     */

    @Override
    public void saveReceipt(ReceiptSaveRequestDto requestDto) {
        Receipt receipt = Receipt.builder().receiptNumber(requestDto.getReceiptNumber()).build();
        receiptRepository.save(receipt);
    }

    @Override
    public ReceiptGetResponseDto getReceipt(ReceiptGetRequestDto requestDto) {
        Receipt receipt = receiptRepository.findById(requestDto.getReceiptId())
                .orElseThrow(() -> new NoSuchElementException());
        return ReceiptGetResponseDto.builder().receipt(receipt).build();
    }
}
