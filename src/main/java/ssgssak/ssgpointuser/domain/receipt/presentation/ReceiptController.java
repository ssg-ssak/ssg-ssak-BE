package ssgssak.ssgpointuser.domain.receipt.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.domain.receipt.application.ReceiptServiceImpl;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetResponseDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveRequestDto;
import ssgssak.ssgpointuser.domain.receipt.vo.ReceiptGetInVo;
import ssgssak.ssgpointuser.domain.receipt.vo.ReceiptGetOutVo;
import ssgssak.ssgpointuser.domain.receipt.vo.ReceiptSaveInVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/receipt")
public class ReceiptController {

    private final ReceiptServiceImpl receiptService;
    private final ModelMapper modelMapper;

    /**
     * 영수증
     * 1. 영수증 저장
     * 2. 영수증 id로, 영수증 조회
     */

    // 1. 영수증 저장
    public void saveReceipt(ReceiptSaveInVo inVo) {
        receiptService.saveReceipt(modelMapper.map(inVo, ReceiptSaveRequestDto.class));
    }

    // 2. 영수증 id로, 영수증 조회
    public ResponseEntity<ReceiptGetOutVo> getReceipt(ReceiptGetInVo inVo) {
        ReceiptGetResponseDto responseDto = receiptService.getReceipt(modelMapper.map(inVo, ReceiptGetRequestDto.class));
        ReceiptGetOutVo outVo = modelMapper.map(responseDto, ReceiptGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
