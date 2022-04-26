package com.example.boardbackend.domain.board;

import com.example.boardbackend.domain.board.entity.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long> {

}
