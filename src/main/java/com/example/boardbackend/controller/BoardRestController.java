package com.example.boardbackend.controller;

import com.example.boardbackend.payroad.BoardRequest;
import com.example.boardbackend.payroad.BoardResponse;
import com.example.boardbackend.query.board.BoardQuery;
import com.example.boardbackend.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Board-Controller")
@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    private final BoardService boardService;
    private final BoardQuery boardQuery;

    @ApiOperation("게시글 등록")
    @PostMapping("/save")
    public ResponseEntity<Object> saveBoard(@RequestBody BoardRequest boardRequest) {
        return ResponseEntity.ok().body(boardService.saveBoard(boardRequest));
    }

    @ApiOperation("게시글 리스트")
    @GetMapping("/list")
    public ResponseEntity<List<BoardResponse>> findBoardList() {
        return ResponseEntity.ok().body(boardQuery.findBoardList());
    }
}
