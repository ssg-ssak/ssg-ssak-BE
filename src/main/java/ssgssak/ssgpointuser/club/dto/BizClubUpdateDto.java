package ssgssak.ssgpointuser.club.dto;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BizClubUpdateDto {
    // 비즈니스 클럽은 제가 가입이 안되다 보니 정확히 어떤 정보 수정이 가능한지 잘 모르겠네요. id와 clubLIstId 제외한 나머지는 수정 가능하다고 가정하고 작성했습니다.
    private String companyName;
    private String companyNumber;
    private String companyLeaderName;
    private String companyAddress;
    private String companyEmail;
    private Boolean agreement;
}
