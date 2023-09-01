package ssgssak.ssgpointuser.domain.giftpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GiftPointRequestDto {
    private String giverUUID;
    private String receiverUUID;
    private String message;
}
