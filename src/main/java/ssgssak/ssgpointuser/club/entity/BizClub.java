package ssgssak.ssgpointuser.club.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class BizClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30, name = "company_name")
    private String companyName;
    @Column(nullable = false, length = 20, name = "company_number")
    private String companyNumber;
    @Column(nullable = false, length = 20, name = "company_leader_name")
    private String companyLeaderName;
    @Column(nullable = false, length = 100, name = "company_address")
    private String companyAddress;
    @Column(nullable = false, length = 30, name = "company_email")
    private String companyEmail;
    // todo: columnDefinition 사용할지 말지 좀 더 고민해보기.
    @Column(nullable = false, name = "agreement", columnDefinition = "boolean default false")
    private Boolean agreement;
    // todo: fetch = FetchType.LAZY 쓰는 것이 맞는지 확인
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_list_id")
    private ClubList clubList;
}
