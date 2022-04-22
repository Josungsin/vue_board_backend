package com.example.boardbackend.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -690394706L;

    public static final QUser user = new QUser("user");

    public final com.example.boardbackend.domain.QSaveTimeEntity _super = new com.example.boardbackend.domain.QSaveTimeEntity(this);

    public final ListPath<com.example.boardbackend.domain.board.entity.Board, com.example.boardbackend.domain.board.entity.QBoard> boards = this.<com.example.boardbackend.domain.board.entity.Board, com.example.boardbackend.domain.board.entity.QBoard>createList("boards", com.example.boardbackend.domain.board.entity.Board.class, com.example.boardbackend.domain.board.entity.QBoard.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath password = createString("password");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath userName = createString("userName");

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

