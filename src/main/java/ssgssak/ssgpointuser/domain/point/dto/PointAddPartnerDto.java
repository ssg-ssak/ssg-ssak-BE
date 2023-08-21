package ssgssak.ssgpointuser.domain.point.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointAddPartnerDto {
    private Integer updatePoint;
    private Boolean used;
}
