package ssgssak.ssgpointuser.domain.franchise.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFranchise is a Querydsl query type for Franchise
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFranchise extends EntityPathBase<Franchise> {

    private static final long serialVersionUID = 996178704L;

    public static final QFranchise franchise = new QFranchise("franchise");

    public final StringPath homepageUrl = createString("homepageUrl");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath logoUrl = createString("logoUrl");

    public final StringPath name = createString("name");

    public QFranchise(String variable) {
        super(Franchise.class, forVariable(variable));
    }

    public QFranchise(Path<? extends Franchise> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFranchise(PathMetadata metadata) {
        super(Franchise.class, metadata);
    }

}

