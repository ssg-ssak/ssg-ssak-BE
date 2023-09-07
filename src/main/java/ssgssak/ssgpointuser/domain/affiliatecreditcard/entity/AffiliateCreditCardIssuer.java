package ssgssak.ssgpointuser.domain.affiliatecreditcard.entity;

public enum AffiliateCreditCardIssuer {
    E_MART("이마트 e카드"),
    KB("이마트2 KB국민카드"),
    SSG_COM("SSG.COM카드"),
    BC("BC바로카드"),
    HANA("하나카드"),
    SHINHAN("신한카드"),
    SSG("SSG카드"),
    CITI("씨티카드");


    private String name;
    AffiliateCreditCardIssuer(String name) {
        this.name = name;
    }
}
