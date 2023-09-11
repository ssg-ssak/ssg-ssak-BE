package ssgssak.ssgpointuser.domain.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.franchise.entity.Franchise;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String storeName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Franchise franchise;

    // 주소를 시, 군(구), 도로명주소 로 나눔
    @Column
    private String city;

    @Column
    private String district;

    @Column
    private String roadAddress;

    // 실제 위치 정보 : 위도와 경도
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;
}
