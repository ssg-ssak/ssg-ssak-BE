package ssgssak.ssgpointuser.domain.eventpoint.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.eventpoint.entity.AttendancePoint;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendancePointGetOutVo {
    private AttendancePoint attendancePoint;
}
