package com.example.boardbackend.domain.board;

import com.example.boardbackend.domain.board.entity.BoardCategory;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Predicate;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long> {

    boolean existsByCategoryName(String name);
    boolean existsByIdx(Long idx);
}
