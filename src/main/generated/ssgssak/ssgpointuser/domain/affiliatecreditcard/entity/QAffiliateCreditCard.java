package ssgssak.ssgpointuser.domain.affiliatecreditcard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAffiliateCreditCard is a Querydsl query type for AffiliateCreditCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAffiliateCreditCard extends EntityPathBase<AffiliateCreditCard> {

    private static final long serialVersionUID = 142974896L;

    public static final QAffiliateCreditCard affiliateCreditCard = new QAffiliateCreditCard("affiliateCreditCard");

    public final ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity _super = new ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity(this);

    public final StringPath cardName = createString("cardName");

    public final StringPath cardNumber = createString("cardNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<AffiliateCreditCardIssuer> issuer = createEnum("issuer", AffiliateCreditCardIssuer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath userUUID = createString("userUUID");

    public QAffiliateCreditCard(String variable) {
        super(AffiliateCreditCard.class, forVariable(variable));
    }

    public QAffiliateCreditCard(Path<? extends AffiliateCreditCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAffiliateCreditCard(PathMetadata metadata) {
        super(AffiliateCreditCard.class, metadata);
    }

}

