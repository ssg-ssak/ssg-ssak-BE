package ssgssak.ssgpointuser.club.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BeautyClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // todo: fetch = FetchType.LAZY 쓰는 것이 맞는지 확인
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_list_id")
    private ClubList clubList;
}
