package ssgssak.ssgpointuser.domain.point.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.point.dto.*;
import ssgssak.ssgpointuser.domain.point.entity.*;
import ssgssak.ssgpointuser.domain.point.infrastructure.PointRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;
    private final ModelMapper modelMapper;

    /**
     * 포인트
     * 1. 유저 기존 totalPoint 조회
     * 2. 포인트 사용/적립 계산
     * 3. 포인트 생성
     * 4. 타입별 포인트 적립 -> 스토어, 파트너, 전환, 영수증을 모두 통합해서 사용
     * 5. 포인트 선물받기(수락) -> 포인트 2개 생성
     * 6. 포인트 조회하기
     * 7. 사용가능 포인트 조회
     * 8. 기간별 적립한/사용한 포인트 계산
     * 9. 이벤트 포인트 적립
     * 10. 이벤트 당일 중복확인 (오늘 날짜로 조회해서 있다면 중복이다)
     * 11. 출석체크 연속 확인하기 (어제부터 9일전까지 출석이 9번이라면, 오늘이 10번째임 -> 추가포인트 지급)
     */


    // 1. 유저 기존 totalPoint 조회
    @Override
    @Transactional(readOnly = true)
    public Integer getTotalPoint(String uuid) {
        Optional<Point> point = pointRepository.findFirstByUserUUIDOrderByCreateAtDesc(uuid);
        if (point.isPresent()) {
            return point.get().getTotalPoint();
        } else {
            return 0;
        }
    }

    // 2. 포인트 사용/적립 계산
    @Override
    public Integer calcTotalPoint(Boolean used, Integer totalPoint, Integer updatePoint) {
        if (!used) {
            totalPoint += updatePoint;
        } else {
            totalPoint -= updatePoint;
        }
        return totalPoint;
    }

    // 3. 포인트 생성
    @Override
    public Point createPoint(CreatePointDto pointDto, String uuid) {
        Integer updateTotalPoint = calcTotalPoint(pointDto.getUsed(), getTotalPoint(uuid), pointDto.getUpdatePoint());
        pointDto = pointDto.toBuilder().totalPoint(updateTotalPoint).build();
        Point point = Point.builder().isEvent(pointDto.getType().getIsEvent()).userUUID(uuid).build();
        modelMapper.map(pointDto, point);
        return point;
    }

    // 4. 타입별, 포인트 적립
    @Override
    public PointIdOutDto pointAdd(CreatePointDto pointDto, String uuid) {
        // 포인트 계산
        Point point = createPoint(pointDto, uuid);
        pointRepository.save(point);
        Long pointId = point.getId();

        return PointIdOutDto.builder().pointId(pointId).build();
    }

    // 5. 포인트 선물받기(수락) -> 포인트 생성
    @Override
    public PointGiftAcceptResponseDto receiveGiftPoint(PointGiftAcceptRequestDto requestDto, String receiverUUID) {
        String giverUUID = requestDto.getGiverUUID();

        // giver 포인트 생성
        Integer updateGiverTotalPoint = calcTotalPoint(true, getTotalPoint(giverUUID), requestDto.getUpdatePoint());
        CreatePointDto createPointGiverDto = modelMapper.map(requestDto, CreatePointDto.class);
        createPointGiverDto = createPointGiverDto.toBuilder().used(true).uuid(giverUUID).totalPoint(updateGiverTotalPoint).build();
        Point givePoint = createPoint(createPointGiverDto, giverUUID);
        pointRepository.save(givePoint);
        Long givePointId = givePoint.getId();

        // receiver 포인트 생성
        Integer updateReceiverTotalPoint = calcTotalPoint(false, getTotalPoint(receiverUUID), requestDto.getUpdatePoint());
        CreatePointDto createPointReceiverDto = modelMapper.map(requestDto, CreatePointDto.class);
        createPointReceiverDto = createPointReceiverDto.toBuilder().used(false).uuid(receiverUUID).totalPoint(updateReceiverTotalPoint).build();
        Point receivePoint = createPoint(createPointReceiverDto, receiverUUID);
        pointRepository.save(receivePoint);
        Long receivePointId = receivePoint.getId();

        return PointGiftAcceptResponseDto.builder()
                .givePointId(givePointId)
                .receivePointId(receivePointId)
                .build();
    }

    // 6. 포인트 조회하기
    @Override
    @Transactional(readOnly = true)
    public PointListResponseDto pointSearch(PointListRequestDto requestDto, String uuid) {
        LocalDateTime startDay = requestDto.getStartDay();
        LocalDateTime endDay = requestDto.getEndDay();
        PointType type = requestDto.getType();
        Boolean used = requestDto.getUsed();
        Boolean isEvent = requestDto.getIsEvent();
        log.info("sttday : "+startDay);
        log.info("endday : "+endDay);

        List<Point> pointList = null;
        // 기간이 정해져 있을 때
        if (startDay != null && endDay != null) {
            // 1. 전체 조회
            if (type == null && used == null) {
                pointList = pointRepository.findAllByUserUUIDAndCreateAtBetween(uuid, startDay, endDay);
                log.info("pointList : "+pointList);
            }
            // 2. 전체 타입을, 선택한 사용유무로 검색
            else if (type == null && used != null) {
                pointList = pointRepository.findAllByUserUUIDAndUsedAndCreateAtBetween(uuid, used, startDay, endDay);
            }
            // 3. 선택한 타입을, 전체 사용유무로 검색
            else if (type != null && used == null) {
                // 일반 타입이라면, 이벤트를 제외하고 검색한다
                if (isEvent == false) {
                    pointList = pointRepository.findAllByUserUUIDAndIsEventFalseAndCreateAtBetween(uuid, startDay, endDay);
                }
                // 이벤트 타입이라면, 이벤트만 검색한다
                else {
                    pointList = pointRepository.findAllByUserUUIDAndIsEventTrueAndCreateAtBetween(uuid, startDay, endDay);
                }
            }
            // 4. 선택한 타입과, 선택한 사용유무로 검색
            else {
                // 일반 타입이라면, 이벤트를 제외하고 검색한다
                if (isEvent == false) {
                    pointList = pointRepository.findAllByUserUUIDAndIsEventFalseAndUsedAndCreateAtBetween(uuid, used, startDay, endDay);
                }
                // 이벤트 타입이라면, 이벤트만 검색한다
                else {
                    pointList = pointRepository.findAllByUserUUIDAndIsEventTrueAndUsedAndCreateAtBetween(uuid, used, startDay, endDay);
                }
            }
        }
        // 기간 없이, 전체 기간을 조회할때 -> 일단은 선물포인트만
        else {
            // 사용유무 관계없이 전체를 검색
            if (type == PointType.GIFT && used == null) {
                pointList = pointRepository.findAllByUserUUIDAndType(uuid, type);
            }
            // 사용유무에 따라서 검색
            else if (type == PointType.GIFT && used != null) {
                pointList = pointRepository.findAllByUserUUIDAndTypeAndUsed(uuid, type, used);
            }
        }
        // 적립/사용 포인트 계산
        HashMap<String, Integer> addUsedPointList = calcAddUsedPoint(pointList);

        return PointListResponseDto.builder()
                .addTotalPoint(addUsedPointList.get("addPoint"))
                .usedTotalPoint(addUsedPointList.get("usedPoint"))
                .totalRows(pointList.size())
                .pointList(pointList)
                .build();
    }

    // 7. 사용가능 포인트 조회
    @Override
    @Transactional(readOnly = true)
    public PointPossibleResponseDto searchPossible(String uuid) {
        //todo: 일단 totalpoint를 return해주는데, 나중에 적립예정을 빼고 보내야함
        return PointPossibleResponseDto.builder()
                .possiblePoint(getTotalPoint(uuid))
                .build();
    }

    // 8. 기간별 적립한/사용한 포인트 계산
    @Override
    public HashMap<String, Integer> calcAddUsedPoint(List<Point> pointList) {
        HashMap<String, Integer> addUsedPointList = new HashMap<>();
        Integer addPoint = pointList.stream()
                .filter(point -> point.getUsed() == false)
                .mapToInt(Point::getUpdatePoint)
                .sum();
        Integer usedPoint = pointList.stream()
                .filter(point -> point.getUsed() == true)
                .mapToInt(Point::getUpdatePoint)
                .sum();
        addUsedPointList.put("addPoint", addPoint);
        addUsedPointList.put("usedPoint", usedPoint);
        return addUsedPointList;
    }

    // 9. 이벤트 포인트 적립
    @Override
    public PointEventOutDto pointAddEvent(CreatePointDto pointDto, String uuid, Integer continueDay) {
        // 출석체크 이벤트인 경우
        if (pointDto.getType() == PointType.ATTENDANCE) {
            Boolean isContinue = yesterdayAttendance(uuid);
            // 전날에 출석체크를 했고, continueDay가 9라면 -> 10포인트를 추가, continueDay를 0으로 초기화
            if (isContinue == true && continueDay == 9) {
                pointDto = pointDto.toBuilder().updatePoint(10).build();
                continueDay = 1;
            }
            // 전날에 출석체크를 했고, continueDay가 9보다 작다면 -> 1포인트를 추가, continueDay를 +1
            else if (isContinue == true && continueDay < 9) {
                pointDto = pointDto.toBuilder().updatePoint(1).build();
                continueDay++;
            }// 전날에 출석체크를 하지 않았다면 -> 1포인트를 추가, continueDay를 1로 초기화
            else {
                pointDto = pointDto.toBuilder().updatePoint(1).build();
                continueDay = 1;
            }
        }
        Point point = createPoint(pointDto, uuid);
        pointRepository.save(point);
        Long pointId = point.getId();

        return PointEventOutDto.builder().pointId(pointId).continueDay(continueDay).build();
    }

    // 10. 이벤트 당일 중복확인 (오늘 날짜로 조회해서 있다면 중복이다)
    @Override
    @Transactional(readOnly = true)
    public CheckDuplicateDto checkDuplicate(String uuid, PointType type) {
        LocalDateTime stt = LocalDate.now().atStartOfDay(); // 오늘
        LocalDateTime end = LocalDate.now().plusDays(1).atStartOfDay(); // 내일
        log.info("stt: "+stt +" end: "+end);
        // 오늘-내일 사이에서, uuid와 type에 해당하는, 이벤트 포인트를 반환
        List<Point> pointList = pointRepository.findAllByUserUUIDAndTypeAndIsEventTrueAndCreateAtBetween(uuid, type, stt, end);
        log.info("pointList : " + pointList);
        CheckDuplicateDto checkDuplicateDto = CheckDuplicateDto.builder().build();
        if (pointList.isEmpty() == true) {
            checkDuplicateDto = checkDuplicateDto.toBuilder().duplicate(false).build();
        } else {
            checkDuplicateDto = checkDuplicateDto.toBuilder().duplicate(true).build();
        }
        log.info("check : " + checkDuplicateDto);
        return checkDuplicateDto;
    }

    // 11. 어제의 출석체크 유무 조회
    @Override
    @Transactional(readOnly = true)
    public Boolean yesterdayAttendance(String uuid) {
        LocalDateTime yesterdayStart = LocalDate.now().minusDays(1).atStartOfDay();
        LocalDateTime yesterdayEnd = LocalDate.now().atStartOfDay();
        Optional<Point> point = pointRepository.findByUserUUIDAndTypeAndCreateAtBetween(uuid, PointType.ATTENDANCE, yesterdayStart, yesterdayEnd);
        if (point.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
