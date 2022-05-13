package com.example.boardbackend.query;

import com.example.boardbackend.domain.board.BoardCategoryRepository;
import com.example.boardbackend.query.board.BoardQuery;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class BoardQueryTest {

    @Autowired
    private BoardQuery boardQuery;
    @Autowired
    private BoardCategoryRepository boardCategoryRepository;

    @Test
    void exits_test() {
        String name  = "Tech";

        boardCategoryRepository.existsByCategoryName(name);
        boardQuery.existsCategoryName(name);
    }

    @Test
    void 중복체크() {
        List<Integer> originList = new ArrayList<>();
        originList.add(1);
        originList.add(1);
        originList.add(2);
        originList.add(3);
        originList.add(4);
        originList.add(5);

        List<Integer> resultList = originList.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("originList = " + originList);
        System.out.println("resultList = " + resultList);
    }
}