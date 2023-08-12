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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender child1Gender;
    @Column(nullable = false)
    private LocalDate child1Birth;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender child2Gender;
    @Column
    private LocalDate child2Birth;
    @Column(nullable = false)
    private Boolean agreement;
    // todo: fetch = FetchType.LAZY 쓰는 것이 맞는지 확인
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_list_id")
    private ClubList clubList;
}
