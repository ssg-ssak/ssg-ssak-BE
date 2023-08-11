package ssgssak.ssgpointuser.club.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Gender {
    MALE("M", "남자"),
    FEMALE("W", "여자");

    private final String code;
    private final String value;

    Gender(String code, String value){
        this.code = code;
        this.value = value;
    }
}
