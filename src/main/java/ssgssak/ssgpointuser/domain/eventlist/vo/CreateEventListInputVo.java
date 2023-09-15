package ssgssak.ssgpointuser.domain.eventlist.vo;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import ssgssak.ssgpointuser.domain.eventlist.entity.EventType;

import java.time.LocalDate;

@Getter
public class CreateEventListInputVo {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private EventType eventType;
    private Boolean isOver;
    private String titleImageUrl;
}