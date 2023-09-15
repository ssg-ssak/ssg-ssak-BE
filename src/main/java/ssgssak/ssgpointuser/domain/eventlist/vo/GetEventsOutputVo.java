package ssgssak.ssgpointuser.domain.eventlist.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.eventlist.entity.EventList;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetEventsOutputVo {
    List<EventList> events;
}
