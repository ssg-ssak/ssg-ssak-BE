package ssgssak.ssgpointuser.domain.partnerpoint.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPartnerPoint is a Querydsl query type for PartnerPoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPartnerPoint extends EntityPathBase<PartnerPoint> {

    private static final long serialVersionUID = -483439430L;

    public static final QPartnerPoint partnerPoint = new QPartnerPoint("partnerPoint");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> pointId = createNumber("pointId", Long.class);

    public final EnumPath<PartnerType> type = createEnum("type", PartnerType.class);

    public QPartnerPoint(String variable) {
        super(PartnerPoint.class, forVariable(variable));
    }

    public QPartnerPoint(Path<? extends PartnerPoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPartnerPoint(PathMetadata metadata) {
        super(PartnerPoint.class, metadata);
    }

}

