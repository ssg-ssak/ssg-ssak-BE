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
public class AttendancePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "int default 1")
    private Integer continueCheck; //최대 10일, 10일이 된다면 다음날은 1로 초기화

    @Column(nullable = false)
    private Long pointId;
}
