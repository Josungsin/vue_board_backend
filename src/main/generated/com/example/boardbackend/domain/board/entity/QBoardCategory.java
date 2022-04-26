package com.example.boardbackend.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardCategory is a Querydsl query type for BoardCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoardCategory extends EntityPathBase<BoardCategory> {

    private static final long serialVersionUID = 1739804572L;

    public static final QBoardCategory boardCategory = new QBoardCategory("boardCategory");

    public final ListPath<Board, QBoard> board = this.<Board, QBoard>createList("board", Board.class, QBoard.class, PathInits.DIRECT2);

    public final StringPath categoryName = createString("categoryName");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public QBoardCategory(String variable) {
        super(BoardCategory.class, forVariable(variable));
    }

    public QBoardCategory(Path<? extends BoardCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardCategory(PathMetadata metadata) {
        super(BoardCategory.class, metadata);
    }

}

