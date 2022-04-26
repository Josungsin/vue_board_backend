package com.example.boardbackend.service;

import com.example.boardbackend.Exception.BadRequestException;
import com.example.boardbackend.controller.BoardRestController;
import com.example.boardbackend.domain.board.BoardCategoryRepository;
import com.example.boardbackend.domain.board.BoardRepository;
import com.example.boardbackend.domain.board.entity.Board;
import com.example.boardbackend.domain.board.entity.BoardCategory;
import com.example.boardbackend.payroad.BoardListResponse;
import com.example.boardbackend.payroad.BoardRequest;
import com.example.boardbackend.query.board.BoardQuery;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardCategoryRepository boardCategoryRepository;
    private final BoardQuery boardQuery;

    @Transactional
    public Long saveBoard(BoardRequest boardRequest){

       BoardCategory boardCategory = boardCategoryRepository.findById(boardRequest.getCategoryIdx())
               .orElseThrow(() -> new BadRequestException("카테고리가 존재하지 않습니다."));

        Board board = Board.builder()
                .userEmail(boardRequest.getUserEmail())
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .boardCategory(boardCategory)
                .build();

        boardRepository.save(board);

        return board.getIdx();
    }

    public List<BoardListResponse> findBoardList(BoardRestController.BoardSearchTypeEnum searchType, String searchKeyword) {

        BooleanBuilder builder = new BooleanBuilder();

        if (searchType != null && searchKeyword != null) {
            builder.and(searchType.getPath().like(String.format("%%%s%%", searchKeyword)));
        }

        return boardQuery.findBoardList(builder);
    }

}
