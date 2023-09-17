package ssgssak.ssgpointuser.domain.point.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PointPossibleResponseDto {
    private Integer possiblePoint;
    //todo: 적립예정, 소멸예정 해야함
}
