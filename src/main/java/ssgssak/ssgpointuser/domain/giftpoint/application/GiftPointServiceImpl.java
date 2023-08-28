package ssgssak.ssgpointuser.domain.giftpoint.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.giftpoint.dto.*;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftPoint;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftStatus;
import ssgssak.ssgpointuser.domain.giftpoint.infrastructure.GiftPointRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class GiftPointServiceImpl implements GiftPointService{
    private final GiftPointRepository giftPointRepository;
    private final ModelMapper modelMapper;

    /**
     * 선물 포인트
     * 1. 선물 포인트 생성
     * 2. 포인트 선물하기
     * 3. 포인트 선물받기(수락)
     * 4. 포인트 선물받기(거절)
     * 5. 포인트 선물 대기리스트 조회
     * 6. 선물 포인트 조회
     */

    // 1. 선물 포인트 생성
    @Override
    public GiftPoint createGiftPoint(GiftPointRequestDto requestDto) {
        GiftPoint giftPoint = GiftPoint.builder().status(GiftStatus.WAIT).build();
        modelMapper.map(requestDto, giftPoint);
        return giftPoint;
    }

    // 2. 포인트 선물하기
    @Override
    public void giveGiftPoint(GiftPointRequestDto requestDto) {
        giftPointRepository.save(createGiftPoint(requestDto));
    }

    // 3. 포인트 선물받기(수락)
    @Override
    public void acceptGiftPoint(GiftPointAcceptDto acceptDto) {
        GiftPoint giftPoint = giftPointRepository.findByReceiverUUIDAndCreateAt(acceptDto.getReceiverUUID(), acceptDto.getCreateAt())
                .orElseThrow(()-> new NoSuchElementException("해당 값이 존재하지 않습니다"));
        giftPoint.setGiveAndReceivePointId(acceptDto.getGivePointId(), acceptDto.getReceivePointId());
        giftPoint.updateStatus(GiftStatus.ACCEPT);
    }

    // 4. 포인트 선물받기(거절)
    @Override
    public void refuseGiftPoint(GiftPointRefuseDto refuseDto) {
        GiftPoint giftPoint = giftPointRepository.findByReceiverUUIDAndCreateAt(refuseDto.getReceiverUUID(), refuseDto.getCreateAt())
                .orElseThrow(()-> new NoSuchElementException("해당 값이 존재하지 않습니다"));
        giftPoint.updateStatus(GiftStatus.REFUSE);
    }

    // 5. 포인트 선물 대기리스트 조회 todo: 포인트 대기 15일 이후에는 자동 거절 되어야함
    @Override
    public GiftPointWaitListDto getGiftWaitList(String uuid) {
        List<GiftPoint> waitList = giftPointRepository.findByReceiverUUIDAndStatusOrderByCreateAtAsc(uuid, GiftStatus.WAIT);
        GiftPointWaitListDto waitListDto = GiftPointWaitListDto.builder()
                .waitList(waitList)
                .build();
        return waitListDto;
    }

    // 6. 선물 포인트 조회(uuid & 생성날짜, 사용유무로 판단)
    @Override
    public GiftPointGetResponseDto getGiftList(GiftPointGetRequestDto requestDto) {
        GiftPoint giftPoint = null;
        String userUUID = null;
        // 보낸 선물 조회
        if (requestDto.getUsed() == true) {
            giftPoint = giftPointRepository.findByGiverUUIDAndCreateAt(requestDto.getUuid(), requestDto.getCreateAt())
                    .orElseThrow(() -> new NoSuchElementException());
            userUUID = giftPoint.getReceiverUUID();
        }
        // 받은 선물 조회
        else if (requestDto.getUsed() == false) {
            giftPoint = giftPointRepository.findByReceiverUUIDAndCreateAt(requestDto.getUuid(), requestDto.getCreateAt())
                    .orElseThrow(() -> new NoSuchElementException());
            userUUID = giftPoint.getGiverUUID();
        }
        return GiftPointGetResponseDto.builder()
                .message(giftPoint.getMessage())
                .userUUID(userUUID)
                .build();
    }

}
