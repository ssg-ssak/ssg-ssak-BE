package ssgssak.ssgpointuser.domain.point.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.point.dto.PointAddPartnerDto;
import ssgssak.ssgpointuser.domain.point.dto.PointAddStoreDto;
import ssgssak.ssgpointuser.domain.point.entity.Point;
import ssgssak.ssgpointuser.domain.point.entity.PointType;
import ssgssak.ssgpointuser.domain.point.infrastructure.PointRepository;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;
    private final UserRepository userRepository;


    /**
     * 포인트
     * 1. 유저 조회
     * 2. 유저 기존 totalPoint 조회
     * 3. 포인트 사용/적립 계산
     * 3. 가맹점(스토어)로 적립
     * 4. 제휴사(파트너)로 적립
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
        Optional<Point> point = pointRepository.findFirstByUser_UserUUIDOrderByCreateAtDesc(uuid);
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

    // 3. 가맹점(스토어)로 적립
    @Override
    public void pointAddStore(PointAddStoreDto storeDto, String uuid) {
        User user = getUser(uuid);
        Boolean used = storeDto.getUsed();
        Integer updatePoint = storeDto.getUpdatePoint();
        // 포인트 계산
        Integer totalPoint = getTotalPoint(uuid);
        Integer updateTotalPoint = calcTotalPoint(used, totalPoint, updatePoint);
        Point point = Point.builder()
                .updatePoint(updatePoint)
                .used(used)
                .type(PointType.STORE)
                .user(user)
                .totalPoint(updateTotalPoint)
                .build();
        pointRepository.save(point);
    }

    // 4. 제휴사(파트너)로 적립
    @Override
    public void pointAddPartner(PointAddPartnerDto partnerDto, String uuid) {
        User user = getUser(uuid);
        Boolean used = partnerDto.getUsed();
        Integer updatePoint = partnerDto.getUpdatePoint();
        // 포인트 계산
        Integer totalPoint = getTotalPoint(uuid);
        Integer updateTotalPoint = calcTotalPoint(used, totalPoint, updatePoint);
        Point point = Point.builder()
                .updatePoint(updatePoint)
                .used(used)
                .type(PointType.PARTNER)
                .user(user)
                .totalPoint(updateTotalPoint)
                .build();
        pointRepository.save(point);
    }

}
