package ssgssak.ssgpointuser.domain.receipt.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.receipt.application.ReceiptServiceImpl;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptGetResponseDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveRequestDto;
import ssgssak.ssgpointuser.domain.receipt.dto.ReceiptSaveResponseDto;
import ssgssak.ssgpointuser.domain.receipt.vo.*;

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
     * 3. 영수증 번호로, 영수증 조회
     */

    // 1. 영수증 저장
    @PostMapping("")
    public ResponseEntity<ReceiptSaveOutVo> saveReceipt(@RequestBody ReceiptSaveInVo inVo) {
        ReceiptSaveResponseDto responseDto = receiptService.saveReceipt(modelMapper.map(inVo, ReceiptSaveRequestDto.class));
        ReceiptSaveOutVo outVo = modelMapper.map(responseDto, ReceiptSaveOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

    // 2. 영수증 id로, 영수증 조회
    @GetMapping("/by/id")
    public ResponseEntity<ReceiptGetOutVo> getReceiptById(@RequestParam Long receiptId) {
        ReceiptGetResponseDto responseDto = receiptService.getReceiptById(receiptId);
        ReceiptGetOutVo outVo = modelMapper.map(responseDto, ReceiptGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

    // 3. 영수증 번호로, 영수증 조회
    @GetMapping("/by/number")
    public ResponseEntity<ReceiptGetOutVo> getReceiptByNumber(@RequestParam String receiptNumber) {
        ReceiptGetResponseDto responseDto = receiptService.getReceiptByNumber(receiptNumber);
        ReceiptGetOutVo outVo = modelMapper.map(responseDto, ReceiptGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
