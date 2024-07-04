package com.sparta.everydrink.domain.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTimeStampEntity is a Querydsl query type for TimeStampEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QTimeStampEntity extends EntityPathBase<TimeStampEntity> {

    private static final long serialVersionUID = 707464917L;

    public static final QTimeStampEntity timeStampEntity = new QTimeStampEntity("timeStampEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public QTimeStampEntity(String variable) {
        super(TimeStampEntity.class, forVariable(variable));
    }

    public QTimeStampEntity(Path<? extends TimeStampEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTimeStampEntity(PathMetadata metadata) {
        super(TimeStampEntity.class, metadata);
    }

}

