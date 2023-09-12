package ssgssak.ssgpointuser.domain.eventpoint.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAttendancePoint is a Querydsl query type for AttendancePoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttendancePoint extends EntityPathBase<AttendancePoint> {

    private static final long serialVersionUID = 286120807L;

    public static final QAttendancePoint attendancePoint = new QAttendancePoint("attendancePoint");

    public final ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity _super = new ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity(this);

    public final NumberPath<Integer> continueDay = createNumber("continueDay", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> pointId = createNumber("pointId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAttendancePoint(String variable) {
        super(AttendancePoint.class, forVariable(variable));
    }

    public QAttendancePoint(Path<? extends AttendancePoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttendancePoint(PathMetadata metadata) {
        super(AttendancePoint.class, metadata);
    }

}

