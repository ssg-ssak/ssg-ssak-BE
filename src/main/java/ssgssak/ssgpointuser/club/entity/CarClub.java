package ssgssak.ssgpointuser.club.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "region")
    @Enumerated(EnumType.STRING)
    private Region region;
    @Column(nullable = false, length = 10, name = "first_number")
    private String firstNumber;
    @Column(nullable = false, length = 10, name = "middle_number")
    private String middleNumber;
    @Column(nullable = false, length = 10, name = "last_number")
    private String lastNumber;
    // todo: columnDefinition 사용할지 말지 좀 더 고민해보기.
    @Column(nullable = false, name = "agree_essential", columnDefinition = "boolean default false")
    private Boolean agreeEssential;
    @Column(nullable = false, name = "agree_select", columnDefinition = "boolean default false")
    private Boolean agreeSelect;
    // todo: fetch = FetchType.LAZY 쓰는 것이 맞는지 확인
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_list_id")
    private ClubList clubList;
}
