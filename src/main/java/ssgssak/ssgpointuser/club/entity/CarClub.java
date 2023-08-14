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
    @Column(nullable = false, name = "agree_essential", columnDefinition = "boolean default false")
    private Boolean agreeEssential;
    @Column(nullable = false, name = "agree_select", columnDefinition = "boolean default false")
    private Boolean agreeSelect;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_list_id")
    private ClubList clubList;
}
