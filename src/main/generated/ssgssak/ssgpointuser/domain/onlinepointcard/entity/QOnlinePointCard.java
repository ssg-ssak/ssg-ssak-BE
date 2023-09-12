package ssgssak.ssgpointuser.domain.onlinepointcard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOnlinePointCard is a Querydsl query type for OnlinePointCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOnlinePointCard extends EntityPathBase<OnlinePointCard> {

    private static final long serialVersionUID = -1907919600L;

    public static final QOnlinePointCard onlinePointCard = new QOnlinePointCard("onlinePointCard");

    public final ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity _super = new ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity(this);

    public final StringPath cardNumber = createString("cardNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final StringPath cvc = createString("cvc");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<OnlinePointCardIssuer> issuer = createEnum("issuer", OnlinePointCardIssuer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath userUUID = createString("userUUID");

    public QOnlinePointCard(String variable) {
        super(OnlinePointCard.class, forVariable(variable));
    }

    public QOnlinePointCard(Path<? extends OnlinePointCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOnlinePointCard(PathMetadata metadata) {
        super(OnlinePointCard.class, metadata);
    }

}

