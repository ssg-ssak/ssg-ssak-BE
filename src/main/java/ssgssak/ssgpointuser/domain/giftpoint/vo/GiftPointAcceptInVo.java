package ssgssak.ssgpointuser.domain.giftpoint.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ToString
public class GiftPointAcceptInVo {
    private Long givePointId;
    private Long receivePointId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createAt;
}


