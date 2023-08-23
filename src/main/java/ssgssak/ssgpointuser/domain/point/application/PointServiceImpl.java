package ssgssak.ssgpointuser.domain.point.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.point.dto.*;
import ssgssak.ssgpointuser.domain.point.entity.*;
import ssgssak.ssgpointuser.domain.point.infrastructure.ExchangePointRepository;
import ssgssak.ssgpointuser.domain.point.infrastructure.GiftPointRepository;
import ssgssak.ssgpointuser.domain.point.infrastructure.PointRepository;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;

import java.time.LocalDateTime;
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
    private final ExchangePointRepository exchangePointRepository;


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
     * 9. 포인트 전환하기
     * 10. 포인트 조회하기
     * 11. 날짜 변환
     * 12. 사용가능 포인트 조회
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

    // 9. 포인트 전환하기
    @Override
    public void pointExchange(PointExchangeDto exchangeDto, String uuid) {
        Boolean used = exchangeDto.getUsed();
        Integer exchangePoint = exchangeDto.getExchangePoint();
        // 포인트 계산
        Integer totalPoint = getTotalPoint(uuid);
        Integer updateTotalPoint = calcTotalPoint(used, totalPoint, exchangePoint);

        // 포인트 생성
        Point point = Point.builder()
                .totalPoint(updateTotalPoint)
                .updatePoint(exchangePoint)
                .used(used)
                .type(PointType.EXCHANGE)
                .userUUID(uuid)
                .build();
        pointRepository.save(point);
        Long pointId = point.getId();

        // 전환 포인트 생성
        ExchangePoint exPoint = ExchangePoint.builder()
                .type(exchangeDto.getType())
                .pointId(pointId)
                .build();
        exchangePointRepository.save(exPoint);
    }

    // 10. 포인트 조회하기
    @Override
    public PointListResponseDto pointSearch(PointType type,
                                            Boolean used,
                                            String startDay,
                                            String endDay,
                                            String uuid) {
        // String으로 들어온 날짜를 LocalDateTime으로 바꿈
        LocalDateTime sttDay = changeDate(startDay);
        LocalDateTime eddDay = changeDate(endDay);
        List<Point> pointList;

        // 1. 전체 조회
        if (type == null && used == null) {
            pointList = pointRepository.findAllByUserUUIDAndCreateAtBetween(uuid, sttDay, eddDay);
        }
        // 2. 전체 타입을, 선택한 사용유무로 검색
        else if (type == null && used != null) {
            pointList = pointRepository.findAllByUserUUIDAndUsedAndCreateAtBetween(uuid, used, sttDay, eddDay);
        }
        // 3. 선택한 타입을, 전체 사용유무로 검색
        else if (type != null && used == null) {
            // 일반 타입이라면, 이벤트를 제외하고 검색한다
            if (type == PointType.GENERAL) {
                pointList = pointRepository.findAllByUserUUIDAndTypeNotAndCreateAtBetween(uuid, PointType.EVENT, sttDay, eddDay);
            }
            // 이벤트 타입이라면, 이벤트만 검색한다
            else {
                pointList = pointRepository.findAllByUserUUIDAndTypeAndCreateAtBetween(uuid, type, sttDay, eddDay);
            }
        }
        // 4. 선택한 타입과, 선택한 사용유무로 검색
        else {
            // 일반 타입이라면, 이벤트를 제외하고 검색한다
            if (type == PointType.GENERAL) {
                pointList = pointRepository.findAllByUserUUIDAndTypeNotAndUsedAndCreateAtBetween(uuid, PointType.EVENT, used, sttDay, eddDay);
            }
            // 이벤트 타입이라면, 이벤트만 검색한다
            else {
                pointList = pointRepository.findAllByUserUUIDAndTypeAndUsedAndCreateAtBetween(uuid, type, used, sttDay, eddDay);
            }
        }

        return PointListResponseDto.builder()
                .pointList(pointList)
                .build();
    }

    // 11. 날짜 변환
    @Override
    public LocalDateTime changeDate(String date) {
        // LocalDateTime은 모든 파라미터를 int형태로 받기때문에 변환시켜줘야함
        return LocalDateTime.of(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(4, 6)),
                Integer.parseInt(date.substring(6, 8)),
                0,0);
    }

    // 12. 사용가능 포인트 조회
    @Override
    public PointPossibleResponseDto searchPossible(String uuid) {
        // todo: 일단 totalpoint를 return해주는데, 나중에 적립예정을 빼고 보내야함
        return PointPossibleResponseDto.builder()
                .possiblePoint(getTotalPoint(uuid))
                .build();
    }
}
