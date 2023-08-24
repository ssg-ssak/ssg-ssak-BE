package ssgssak.ssgpointuser.domain.point.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PointListResponseDto {
    private Integer addTotalPoint;
    private Integer usedTotalPoint;
    private Integer totalRows;
    private List pointList;
}
