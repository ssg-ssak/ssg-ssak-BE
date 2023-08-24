package ssgssak.ssgpointuser.domain.point.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointListOutVo {
    private Integer addTotalPoint;
    private Integer usedTotalPoint;
    private Integer totalRows;
    private List pointList;
}
