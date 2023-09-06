package ssgssak.ssgpointuser.domain.onlinepointcard.entity;

import lombok.Getter;

@Getter
public enum OnlinePointCardIssuer {
    SSG_P("신세계포인트"),
    E_MART("이마트"),
    SSG_DS("신세계백화점"),
    SSG_C("SSG.COM"),
    SSG_O("신세계아울렛"),
    CHICOR("시코르"),
    E_ED("이마트 에브리데이"),
    SSG_GO("쓱고우"),
    SSG_DF("신세계면세점"),
    SSG_CS("신세계까사"),
    SF("스타필드"),
    SSG_U("신세계 유니버스 클럽"),
    SSG_PAY("SSG PAY"),
    KAKAO("카카오페이"),
    SYRUP("시럽");

    private String name;
    OnlinePointCardIssuer(String name) {
        this.name = name;
    }
}
