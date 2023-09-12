package ssgssak.ssgpointuser.domain.giftpoint.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGiftPoint is a Querydsl query type for GiftPoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGiftPoint extends EntityPathBase<GiftPoint> {

    private static final long serialVersionUID = -319321776L;

    public static final QGiftPoint giftPoint = new QGiftPoint("giftPoint");

    public final ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity _super = new ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> givePointId = createNumber("givePointId", Long.class);

    public final StringPath giverUUID = createString("giverUUID");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final NumberPath<Long> receivePointId = createNumber("receivePointId", Long.class);

    public final StringPath receiverUUID = createString("receiverUUID");

    public final EnumPath<GiftStatus> status = createEnum("status", GiftStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QGiftPoint(String variable) {
        super(GiftPoint.class, forVariable(variable));
    }

    public QGiftPoint(Path<? extends GiftPoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGiftPoint(PathMetadata metadata) {
        super(GiftPoint.class, metadata);
    }

}

