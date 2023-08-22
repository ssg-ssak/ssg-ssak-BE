package ssgssak.ssgpointuser.domain.point.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.point.dto.*;
import ssgssak.ssgpointuser.domain.point.entity.GiftPoint;
import ssgssak.ssgpointuser.domain.point.entity.GiftStatus;
import ssgssak.ssgpointuser.domain.point.entity.Point;
import ssgssak.ssgpointuser.domain.point.entity.PointType;
import ssgssak.ssgpointuser.domain.point.infrastructure.GiftPointRepository;
import ssgssak.ssgpointuser.domain.point.infrastructure.PointRepository;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;
    private final UserRepository userRepository;
    private final GiftPointRepository giftPointRepository;


    /**
     * 포인트
     * 1. 유저 조회
     * 2. 유저 기존 totalPoint 조회
     * 3. 포인트 사용/적립 계산
     * 4. 가맹점(스토어)로 적립
     * 5. 제휴사(파트너)로 적립
     * 6. 포인트 선물하기
     * 7. 포인트 선물받기 //todo: 거절한 포인트 선물은, 포인트 조회에 나오지 않음
     * 8. 포인트 선물 대기리스트 조회 //todo: 포인트 대기 15일 이후에는 자동 거절 되어야함
     */

    // 1. 유저 조회
    @Override
    public User getUser(String uuid) {
        User user = userRepository.findUserByUserUUID(uuid)
                .orElseThrow(()-> new NoSuchElementException("해당하는 유저가 없습니다"));
        return user;
    }

    // 2. 유저 기존 totalPoint 조회
    @Override
    public Integer getTotalPoint(String uuid) {
        Optional<Point> point = pointRepository.findFirstByUserUUIDOrderByCreateAtDesc(uuid);
        if (point.isPresent()) {
            return point.get().getTotalPoint();
        } else {
            return 0;
        }
    }

    // 3. 포인트 사용/적립 계산
    @Override
    public Integer calcTotalPoint(Boolean used, Integer totalPoint, Integer updatePoint) {
        if (!used) {
            totalPoint += updatePoint;
        } else {
            totalPoint -= updatePoint;
        }
        return totalPoint;
    }

    // 4. 가맹점(스토어)로 적립
    @Override
    public void pointAddStore(PointAddStoreDto storeDto, String uuid) {
        Boolean used = storeDto.getUsed();
        Integer updatePoint = storeDto.getUpdatePoint();
        // 포인트 계산
        Integer totalPoint = getTotalPoint(uuid);
        Integer updateTotalPoint = calcTotalPoint(used, totalPoint, updatePoint);
        Point point = Point.builder()
                .updatePoint(updatePoint)
                .used(used)
                .type(PointType.STORE)
                .userUUID(uuid)
                .totalPoint(updateTotalPoint)
                .build();
        pointRepository.save(point);
    }

    // 5. 제휴사(파트너)로 적립
    @Override
    public void pointAddPartner(PointAddPartnerDto partnerDto, String uuid) {
        Boolean used = partnerDto.getUsed();
        Integer updatePoint = partnerDto.getUpdatePoint();
        // 포인트 계산
        Integer totalPoint = getTotalPoint(uuid);
        Integer updateTotalPoint = calcTotalPoint(used, totalPoint, updatePoint);
        Point point = Point.builder()
                .updatePoint(updatePoint)
                .used(used)
                .type(PointType.PARTNER)
                .userUUID(uuid)
                .totalPoint(updateTotalPoint)
                .build();
        pointRepository.save(point);
    }

    // 6. 포인트 선물하기
    @Override
    public void giveGiftPoint(PointGiftRequestDto pointGiftDto) {
        GiftPoint giftPoint = GiftPoint.builder()
                .giverUUID(pointGiftDto.getUuid())
                .receiverUUID(pointGiftDto.getReceiverUUID())
                .status(GiftStatus.WAIT)
                .updatePoint(pointGiftDto.getUpdatePoint())
                .build();
        giftPointRepository.save(giftPoint);
    }

    // 7. 포인트 선물받기
    @Override
    public void receiveGiftPoint(PointGiftResponseDto responseDto) {
        log.info("변환 : " + responseDto);
        String receiverUUID = responseDto.getUuid();
        GiftPoint giftPoint = giftPointRepository.findById(responseDto.getGiftPointId())
                .orElseThrow(()->new NoSuchElementException("해당하는 선물 포인트가 없습니다"));

        // 선물받기를 수락한 경우
        if (responseDto.getResponse() == GiftStatus.ACCEPT) {
            Integer updatePoint = giftPoint.getUpdatePoint();
            String giverUUID = giftPoint.getGiverUUID();

            // 주는사람 포인트
            Integer giverTotalPoint = getTotalPoint(giverUUID);
            Integer updateGiverTotalPoint = calcTotalPoint(true, giverTotalPoint, updatePoint);
            Point givePoint = Point.builder()
                    .updatePoint(updatePoint)
                    .used(true)
                    .type(PointType.GIFT)
                    .userUUID(giverUUID)
                    .totalPoint(updateGiverTotalPoint)
                    .build();
            pointRepository.save(givePoint);
            Long givePointId = givePoint.getId();

            // 받는사람 포인트
            Integer receiverTotalPoint = getTotalPoint(receiverUUID);
            Integer updateReceiverTotalPoint = calcTotalPoint(false, receiverTotalPoint, updatePoint);
            Point receivePoint = Point.builder()
                    .updatePoint(updatePoint)
                    .used(false)
                    .type(PointType.GIFT)
                    .userUUID(receiverUUID)
                    .totalPoint(updateReceiverTotalPoint)
                    .build();
            pointRepository.save(receivePoint);
            Long receivePointId = receivePoint.getId();

            // 선물포인트 수정
            giftPoint.setGiveAndReceivePointId(givePointId, receivePointId);
            giftPoint.updateStatus(GiftStatus.ACCEPT);


        // 선물받기를 거절한 경우
        } else if (responseDto.getResponse() == GiftStatus.REFUSE) {
            giftPoint.updateStatus(GiftStatus.REFUSE);
        }
        giftPointRepository.save(giftPoint);
    }


    // 8. 포인트 선물 대기 리스트 조회
    @Override
    public PointGiftWaitListDto getGiftWaitList(String uuid) {
        List<GiftPoint> waitList = giftPointRepository.findByReceiverUUIDAndStatusOrderByCreateAtAsc(uuid, GiftStatus.WAIT);
        PointGiftWaitListDto waitListDto = PointGiftWaitListDto.builder()
                .waitList(waitList)
                .build();
        return waitListDto;
    }
}
