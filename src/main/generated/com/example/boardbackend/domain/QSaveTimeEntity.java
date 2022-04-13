package com.example.boardbackend.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSaveTimeEntity is a Querydsl query type for SaveTimeEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QSaveTimeEntity extends EntityPathBase<SaveTimeEntity> {

    private static final long serialVersionUID = 1463274888L;

    public static final QSaveTimeEntity saveTimeEntity = new QSaveTimeEntity("saveTimeEntity");

    public final DateTimePath<java.time.LocalDateTime> modDate = createDateTime("modDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public QSaveTimeEntity(String variable) {
        super(SaveTimeEntity.class, forVariable(variable));
    }

    public QSaveTimeEntity(Path<? extends SaveTimeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSaveTimeEntity(PathMetadata metadata) {
        super(SaveTimeEntity.class, metadata);
    }

}

