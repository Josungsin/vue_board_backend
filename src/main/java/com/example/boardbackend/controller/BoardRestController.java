package com.example.boardbackend.controller;

import com.example.boardbackend.payroad.BoardRequest;
import com.example.boardbackend.payroad.BoardResponse;
import com.example.boardbackend.query.board.BoardQuery;
import com.example.boardbackend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    private final BoardService boardService;
    private final BoardQuery boardQuery;

    @PostMapping("/save")
    public ResponseEntity<Object> saveBoard(@RequestBody BoardRequest boardRequest) {
        return ResponseEntity.ok().body(boardService.saveBoard(boardRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardResponse>> findBoardList() {
        return ResponseEntity.ok().body(boardQuery.findBoardList());
    }
}
