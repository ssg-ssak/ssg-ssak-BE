package ssgssak.ssgpointuser.domain.affiliatepointcard.entity;

import lombok.Getter;

@Getter
public enum AffiliatePointCardType {
    SAMSUNG("삼성전자 포인트"),
    KOREAN_AIR("대한항공 마일리지"),
    ASIANA_AIR("아시아나마일리지");

    private String name;
    AffiliatePointCardType(String name) {
        this.name = name;
    }
}
