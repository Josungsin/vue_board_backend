package com.example.boardbackend.query.board;

import com.example.boardbackend.payroad.BoardCategoryListResponse;
import com.example.boardbackend.payroad.BoardDetailResponse;
import com.example.boardbackend.payroad.BoardListResponse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.boardbackend.domain.board.entity.QBoard.board;
import static com.example.boardbackend.domain.board.entity.QBoardCategory.boardCategory;

@Repository
public class BoardQuery extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardQuery(JPAQueryFactory jpaQueryFactory) {
        super(BoardQuery.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<BoardListResponse> findBoardList(BooleanBuilder builder) {
        List<BoardListResponse> query = jpaQueryFactory
                .select(Projections.fields(BoardListResponse.class,
                        board.idx,
                        board.boardCategory.categoryName,
                        board.user.userName,
                        board.title,
                        board.content,
                        board.regDate
                ))
                .from(board)
                .innerJoin(board.user)
                .innerJoin(board.boardCategory)
                .where(builder)
                .orderBy(board.regDate.desc())
                .fetch();

        return query;
    }

    public BoardDetailResponse findBoardDetail(Long boardIdx) {
        BoardDetailResponse query = jpaQueryFactory
                .select(Projections.fields(BoardDetailResponse.class,
                        board.idx,
                        board.user.userName,
                        board.title,
                        board.content,
                        board.boardCategory.categoryName,
                        board.regDate,
                        board.modDate
                ))
                .from(board)
                .innerJoin(board.user)
                .innerJoin(board.boardCategory)
                .where(board.idx.eq(boardIdx))
                .fetchOne();

        return query;
    }

    public List<BoardCategoryListResponse> findBoardCategoryList() {
        List<BoardCategoryListResponse> query = jpaQueryFactory
                .select(Projections.fields(BoardCategoryListResponse.class,
                        boardCategory.idx,
                        boardCategory.categoryName
                ))
                .from(boardCategory)
                .fetch();

        return query;
    }

    public boolean existsCategoryName(String name) {
        return from(boardCategory)
                .where(boardCategory.categoryName.eq(name))
                .select(boardCategory.categoryName)
                .fetchFirst() != null;
    }
}
