package ssgssak.ssgpointuser.domain.point.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.global.common.entity.BaseTimeEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftPoint extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String giverUUID;

    @Column(nullable = false)
    private String receiverUUID;

    @Column
    private String message;

    @Column
    private Long givePointId;

    @Column
    private Long receivePointId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GiftStatus status;

    @Column(nullable = false)
    private Integer updatePoint;

    /**
     * 1. give Point와 receive Point 설정
     * 2. 상태 변경
     */

    public void setGiveAndReceivePointId(Long givePointId, Long receivePointId) {
        this.givePointId = givePointId;
        this.receivePointId = receivePointId;
    }

    public void updateStatus(GiftStatus status) {
        this.status = status;
    }
}
