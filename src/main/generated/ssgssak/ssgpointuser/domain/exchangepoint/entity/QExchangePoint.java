package ssgssak.ssgpointuser.domain.exchangepoint.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExchangePoint is a Querydsl query type for ExchangePoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExchangePoint extends EntityPathBase<ExchangePoint> {

    private static final long serialVersionUID = -692049680L;

    public static final QExchangePoint exchangePoint = new QExchangePoint("exchangePoint");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> pointId = createNumber("pointId", Long.class);

    public final EnumPath<ExchangeType> type = createEnum("type", ExchangeType.class);

    public QExchangePoint(String variable) {
        super(ExchangePoint.class, forVariable(variable));
    }

    public QExchangePoint(Path<? extends ExchangePoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExchangePoint(PathMetadata metadata) {
        super(ExchangePoint.class, metadata);
    }

}

