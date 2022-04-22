package com.example.boardbackend.service;

import com.example.boardbackend.domain.board.BoardRepository;
import com.example.boardbackend.domain.board.entity.Board;
import com.example.boardbackend.payroad.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long saveBoard(BoardRequest boardRequest){

        Board board = Board.builder()
                .userEmail(boardRequest.getUserEmail())
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .build();

        boardRepository.save(board);

        return board.getIdx();
    }

}
