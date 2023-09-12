package ssgssak.ssgpointuser.domain.offlinepointcard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOfflinePointCard is a Querydsl query type for OfflinePointCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOfflinePointCard extends EntityPathBase<OfflinePointCard> {

    private static final long serialVersionUID = 1931309828L;

    public static final QOfflinePointCard offlinePointCard = new QOfflinePointCard("offlinePointCard");

    public final ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity _super = new ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity(this);

    public final StringPath cardNumber = createString("cardNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final StringPath cvc = createString("cvc");

    public final StringPath franchiseeName = createString("franchiseeName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath issuedStoreName = createString("issuedStoreName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath userBirth = createString("userBirth");

    public final StringPath userName = createString("userName");

    public final StringPath userUUID = createString("userUUID");

    public QOfflinePointCard(String variable) {
        super(OfflinePointCard.class, forVariable(variable));
    }

    public QOfflinePointCard(Path<? extends OfflinePointCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOfflinePointCard(PathMetadata metadata) {
        super(OfflinePointCard.class, metadata);
    }

}

