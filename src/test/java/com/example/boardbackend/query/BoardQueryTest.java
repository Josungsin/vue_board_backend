package com.example.boardbackend.query;

import com.example.boardbackend.query.board.BoardQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardQueryTest {

    @Autowired
    private BoardQuery boardQuery;

    @Test
    void 조회_테스트() {
        boardQuery.findBoardList();

    }

}