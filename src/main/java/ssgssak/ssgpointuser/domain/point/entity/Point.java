package ssgssak.ssgpointuser.domain.point.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.global.common.entity.BaseTimeEntity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table
public class Point extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer totalPoint;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer updatePoint;

    @Column(nullable = false)
    private Boolean used;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //todo: 시간되면 @converter 사용해볼것
    private PointType type;

    @Column(nullable = false)
    private String userUUID;


}
