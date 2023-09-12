package ssgssak.ssgpointuser.domain.storepoint.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStorePoint is a Querydsl query type for StorePoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStorePoint extends EntityPathBase<StorePoint> {

    private static final long serialVersionUID = 1750381512L;

    public static final QStorePoint storePoint = new QStorePoint("storePoint");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> pointId = createNumber("pointId", Long.class);

    public final NumberPath<Long> receiptId = createNumber("receiptId", Long.class);

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public QStorePoint(String variable) {
        super(StorePoint.class, forVariable(variable));
    }

    public QStorePoint(Path<? extends StorePoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStorePoint(PathMetadata metadata) {
        super(StorePoint.class, metadata);
    }

}

