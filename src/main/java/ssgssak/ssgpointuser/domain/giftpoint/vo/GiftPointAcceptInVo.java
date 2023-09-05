package ssgssak.ssgpointuser.domain.giftpoint.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ToString
public class GiftPointAcceptInVo {
    private Long giftPointId;
    private Long givePointId;
    private Long receivePointId;
}


