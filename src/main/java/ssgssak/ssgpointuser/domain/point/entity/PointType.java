package ssgssak.ssgpointuser.domain.point.entity;

import lombok.Getter;

@Getter
public enum PointType {
    STORE(false),
    GIFT(false),
    EXCHANGE(false),
    PARTNER(false),
    ATTENDANCE(true),
    ROULETTE(true);

    private final Boolean isEvent; // 각 타입에 isEvent를 추가해서, 이벤트인지 일반인지를 구분할 수 있다
    PointType(Boolean isEvent) {
        this.isEvent = isEvent;
    }
}
