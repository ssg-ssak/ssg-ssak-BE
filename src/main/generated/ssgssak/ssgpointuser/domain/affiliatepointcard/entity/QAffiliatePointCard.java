package ssgssak.ssgpointuser.domain.affiliatepointcard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAffiliatePointCard is a Querydsl query type for AffiliatePointCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAffiliatePointCard extends EntityPathBase<AffiliatePointCard> {

    private static final long serialVersionUID = -864657872L;

    public static final QAffiliatePointCard affiliatePointCard = new QAffiliatePointCard("affiliatePointCard");

    public final ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity _super = new ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity(this);

    public final StringPath cardNumber = createString("cardNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final StringPath engName = createString("engName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<AffiliatePointCardType> type = createEnum("type", AffiliatePointCardType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath userUUID = createString("userUUID");

    public QAffiliatePointCard(String variable) {
        super(AffiliatePointCard.class, forVariable(variable));
    }

    public QAffiliatePointCard(Path<? extends AffiliatePointCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAffiliatePointCard(PathMetadata metadata) {
        super(AffiliatePointCard.class, metadata);
    }

}

