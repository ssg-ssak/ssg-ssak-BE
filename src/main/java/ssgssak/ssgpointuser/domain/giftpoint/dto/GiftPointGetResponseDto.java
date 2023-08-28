package ssgssak.ssgpointuser.domain.giftpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GiftPointGetResponseDto {
    private String message;
    private String userUUID;
}
