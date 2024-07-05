package com.sparta.everydrink.domain.liked.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLiked is a Querydsl query type for Liked
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLiked extends EntityPathBase<Liked> {

    private static final long serialVersionUID = 1439046242L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLiked liked = new QLiked("liked");

    public final com.sparta.everydrink.domain.common.QTimeStampEntity _super = new com.sparta.everydrink.domain.common.QTimeStampEntity(this);

    public final com.sparta.everydrink.domain.comment.entity.QComment comment;

    public final NumberPath<Long> contentsId = createNumber("contentsId", Long.class);

    public final EnumPath<ContentsTypeEnum> contentsType = createEnum("contentsType", ContentsTypeEnum.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final com.sparta.everydrink.domain.post.entity.QPost post;

    public final com.sparta.everydrink.domain.user.entity.QUser user;

    public QLiked(String variable) {
        this(Liked.class, forVariable(variable), INITS);
    }

    public QLiked(Path<? extends Liked> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLiked(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLiked(PathMetadata metadata, PathInits inits) {
        this(Liked.class, metadata, inits);
    }

    public QLiked(Class<? extends Liked> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comment = inits.isInitialized("comment") ? new com.sparta.everydrink.domain.comment.entity.QComment(forProperty("comment"), inits.get("comment")) : null;
        this.post = inits.isInitialized("post") ? new com.sparta.everydrink.domain.post.entity.QPost(forProperty("post"), inits.get("post")) : null;
        this.user = inits.isInitialized("user") ? new com.sparta.everydrink.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

