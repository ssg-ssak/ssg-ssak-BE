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
    private String address;

    @Column
    private String storeName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Franchise franchise;

    // 실제 위치 정보 : 위도와 경도
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;
}
