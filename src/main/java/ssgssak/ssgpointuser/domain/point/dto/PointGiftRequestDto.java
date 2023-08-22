package ssgssak.ssgpointuser.domain.point.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PointGiftRequestDto {
    private Integer updatePoint;
    private String uuid;
    private String receiverUUID;
    private String message;
}
