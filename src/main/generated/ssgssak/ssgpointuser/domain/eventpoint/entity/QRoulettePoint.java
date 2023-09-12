package ssgssak.ssgpointuser.domain.eventpoint.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoulettePoint is a Querydsl query type for RoulettePoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoulettePoint extends EntityPathBase<RoulettePoint> {

    private static final long serialVersionUID = 993499708L;

    public static final QRoulettePoint roulettePoint = new QRoulettePoint("roulettePoint");

    public final ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity _super = new ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> pointId = createNumber("pointId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRoulettePoint(String variable) {
        super(RoulettePoint.class, forVariable(variable));
    }

    public QRoulettePoint(Path<? extends RoulettePoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoulettePoint(PathMetadata metadata) {
        super(RoulettePoint.class, metadata);
    }

}

