package ssgssak.ssgpointuser.club.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClubList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ClubType type;
    @Column(nullable = false)
    private LocalDateTime regDate;
    // todo: @JoinColumn(name = user_id) 사용하지 않아도 되는지 확인
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    // todo: fetch = FetchType.LAZY 쓰는 것이 맞는지 확인
    @OneToOne(mappedBy = "clubList", fetch = FetchType.LAZY)
    private MomClub momClub;
}
