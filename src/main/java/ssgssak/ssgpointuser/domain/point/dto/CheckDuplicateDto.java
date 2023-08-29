package ssgssak.ssgpointuser.domain.point.dto;

import lombok.*;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckDuplicateDto {
    private Boolean duplicate;
}
