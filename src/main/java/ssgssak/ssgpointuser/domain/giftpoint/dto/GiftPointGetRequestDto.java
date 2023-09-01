package ssgssak.ssgpointuser.domain.giftpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftPointGetRequestDto {
    private Boolean used;
    private LocalDateTime createAt;
}
