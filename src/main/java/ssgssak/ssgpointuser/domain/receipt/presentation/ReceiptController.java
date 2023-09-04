package ssgssak.ssgpointuser.domain.receipt.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.receipt.application.ReceiptServiceImpl;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetResponseDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveResponseDto;
import ssgssak.ssgpointuser.domain.receipt.vo.ReceiptGetInVo;
import ssgssak.ssgpointuser.domain.receipt.vo.ReceiptGetOutVo;
import ssgssak.ssgpointuser.domain.receipt.vo.ReceiptSaveInVo;
import ssgssak.ssgpointuser.domain.receipt.vo.ReceiptSaveOutVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/receipt")
@Slf4j
public class ReceiptController {

    private final ReceiptServiceImpl receiptService;
    private final ModelMapper modelMapper;

    /**
     * 영수증
     * 1. 영수증 저장
     * 2. 영수증 id로, 영수증 조회
     */

    // 1. 영수증 저장
    @PostMapping("")
    public ResponseEntity<ReceiptSaveOutVo> saveReceipt(@RequestBody ReceiptSaveInVo inVo) {
        ReceiptSaveResponseDto responseDto = receiptService.saveReceipt(modelMapper.map(inVo, ReceiptSaveRequestDto.class));
        ReceiptSaveOutVo outVo = modelMapper.map(responseDto, ReceiptSaveOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

    // 2. 영수증 id로, 영수증 조회
    @GetMapping("")
    public ResponseEntity<ReceiptGetOutVo> getReceipt(ReceiptGetInVo inVo) {
        log.info("id : "+ inVo.getReceiptId());
        ReceiptGetResponseDto responseDto = receiptService.getReceipt(modelMapper.map(inVo, ReceiptGetRequestDto.class));
        ReceiptGetOutVo outVo = modelMapper.map(responseDto, ReceiptGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
