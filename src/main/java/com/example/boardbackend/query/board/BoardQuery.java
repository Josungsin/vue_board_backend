package com.example.boardbackend.query.board;

import com.example.boardbackend.payroad.BoardResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.boardbackend.domain.board.entity.QBoard.board;

@Repository
public class BoardQuery extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardQuery(JPAQueryFactory jpaQueryFactory) {
        super(BoardQuery.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<BoardResponse> findBoardList() {
        List<BoardResponse> query = jpaQueryFactory
                .select(Projections.fields(BoardResponse.class,
                        board.idx,
                        board.userEmail,
                        board.title,
                        board.content,
                        board.regDate
                ))
                .from(board)
                .fetch();

        return query;
    }
}
