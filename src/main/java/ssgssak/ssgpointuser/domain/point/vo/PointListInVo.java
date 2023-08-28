package ssgssak.ssgpointuser.domain.point.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

import java.time.LocalDateTime;

@Getter
public class PointListInVo {
    private String uuid;
    private PointType type;
    private Boolean used;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDay;

    // Setter를 사용하지 않으려면 생성자가 필수이다
    public PointListInVo(String uuid, PointType type, Boolean used, LocalDateTime startDay, LocalDateTime endDay) {
        this.uuid = uuid;
        this.type = type;
        this.used = used;
        this.startDay = startDay;
        this.endDay = endDay;
    }
}
