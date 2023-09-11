package ssgssak.ssgpointuser.domain.point.entity;

import lombok.Getter;

@Getter
public enum PointType { //todo: 소멸예정, 적립예정도 구분해야할듯? -> 포인트 타입으로 구분한건가 아니면 포인트에 필드 추가?
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