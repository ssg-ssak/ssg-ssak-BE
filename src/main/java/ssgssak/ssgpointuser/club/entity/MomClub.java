package ssgssak.ssgpointuser.club.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MomClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "child_1_gender")
    @Enumerated(EnumType.STRING)
    private Gender child1Gender;
    @Column(nullable = false, name = "child_1_birth")
    private LocalDate child1Birth;
    @Column(name = "child_2_gender")
    @Enumerated(EnumType.STRING)
    private Gender child2Gender;
    @Column(name = "child_2_birth")
    private LocalDate child2Birth;
    @Column(nullable = false, name = "agreement", columnDefinition = "boolean default false")
    private Boolean agreement;
    // todo: fetch = FetchType.LAZY 쓰는 것이 맞는지 확인
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_list_id")
    private ClubList clubList;
}
