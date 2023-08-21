package ssgssak.ssgpointuser.domain.point.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String giverUUID;

    @Column(nullable = false)
    private String receiverUUID;

    @Column
    private String message;
}
