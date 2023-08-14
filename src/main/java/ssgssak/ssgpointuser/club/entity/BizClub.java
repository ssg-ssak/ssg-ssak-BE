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
    @Column(nullable = false, name = "agreement", columnDefinition = "boolean default false")
    private Boolean agreement;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_list_id")
    private ClubList clubList;
}
