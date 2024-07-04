package com.sparta.everydrink.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1612090674L;

    public static final QUser user = new QUser("user");

    public final com.sparta.everydrink.domain.common.QTimeStampEntity _super = new com.sparta.everydrink.domain.common.QTimeStampEntity(this);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final ListPath<com.sparta.everydrink.domain.follow.entity.Follow, com.sparta.everydrink.domain.follow.entity.QFollow> followers = this.<com.sparta.everydrink.domain.follow.entity.Follow, com.sparta.everydrink.domain.follow.entity.QFollow>createList("followers", com.sparta.everydrink.domain.follow.entity.Follow.class, com.sparta.everydrink.domain.follow.entity.QFollow.class, PathInits.DIRECT2);

    public final ListPath<com.sparta.everydrink.domain.follow.entity.Follow, com.sparta.everydrink.domain.follow.entity.QFollow> followings = this.<com.sparta.everydrink.domain.follow.entity.Follow, com.sparta.everydrink.domain.follow.entity.QFollow>createList("followings", com.sparta.everydrink.domain.follow.entity.Follow.class, com.sparta.everydrink.domain.follow.entity.QFollow.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath password1 = createString("password1");

    public final StringPath password2 = createString("password2");

    public final StringPath password3 = createString("password3");

    public final StringPath refreshToken = createString("refreshToken");

    public final EnumPath<UserRoleEnum> role = createEnum("role", UserRoleEnum.class);

    public final EnumPath<UserStatusEnum> status = createEnum("status", UserStatusEnum.class);

    public final StringPath username = createString("username");

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

