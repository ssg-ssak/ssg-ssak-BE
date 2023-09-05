package ssgssak.ssgpointuser.domain.giftpoint.vo;

import jakarta.validation.constraints.Null;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class GiftPointGetInVo {
    private Boolean used;
    private Long pointId; // used == true라면 pointId는 givePointId, used==false라면 uuid는 receivePointId

    public GiftPointGetInVo(Boolean used, Long pointId) {
        this.used = used;
        this.pointId = pointId;
    }
}
