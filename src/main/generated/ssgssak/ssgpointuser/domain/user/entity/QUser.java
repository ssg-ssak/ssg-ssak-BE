package ssgssak.ssgpointuser.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -863818912L;

    public static final QUser user = new QUser("user");

    public final ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity _super = new ssgssak.ssgpointuser.global.common.entity.QBaseTimeEntity(this);

    public final StringPath address = createString("address");

    public final StringPath barcodeNumber = createString("barcodeNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath pointPassword = createString("pointPassword");

    public final EnumPath<Roll> roll = createEnum("roll", Roll.class);

    public final DateTimePath<java.time.LocalDateTime> softDelete = createDateTime("softDelete", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public final StringPath userPassword = createString("userPassword");

    public final StringPath userUUID = createString("userUUID");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

