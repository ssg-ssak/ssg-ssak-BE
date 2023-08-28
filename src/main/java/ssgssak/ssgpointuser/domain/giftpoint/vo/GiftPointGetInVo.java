package ssgssak.ssgpointuser.domain.giftpoint.vo;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class GiftPointGetInVo {
    private Boolean used;
    private String uuid;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createAt;
}
