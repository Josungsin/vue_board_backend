package com.example.boardbackend.controller;

import com.example.boardbackend.domain.board.entity.QBoard;
import com.example.boardbackend.payroad.BoardCategoryListResponse;
import com.example.boardbackend.payroad.BoardDetailResponse;
import com.example.boardbackend.payroad.BoardListResponse;
import com.example.boardbackend.payroad.BoardRequest;
import com.example.boardbackend.query.board.BoardQuery;
import com.example.boardbackend.service.BoardService;
import com.querydsl.core.types.dsl.StringPath;
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
    public ResponseEntity<List<BoardListResponse>> findBoardList(@RequestParam(required = false) BoardSearchTypeEnum searchType, String searchKeyword) {
        return ResponseEntity.ok().body(boardService.findBoardList(searchType, searchKeyword));
    }

    @ApiOperation("게시글 상세")
    @GetMapping("/detail/{boardIdx}")
    public ResponseEntity<BoardDetailResponse> findBoardDetail(@PathVariable Long boardIdx) {
        return ResponseEntity.ok().body(boardQuery.findBoardDetail(boardIdx));
    }

    @ApiOperation("게시판 카테고리 리스트")
    @GetMapping("/category-list")
    public ResponseEntity<List<BoardCategoryListResponse>> findBoardCategoryList(){
        return ResponseEntity.ok().body(boardQuery.findBoardCategoryList());
    }

    /**
     * 검색타입
     */
    public enum BoardSearchTypeEnum {
        TITLE(QBoard.board.title), USER(QBoard.board.userEmail);
        private StringPath path;

        BoardSearchTypeEnum(StringPath path) {
            this.path = path;
        }

        public StringPath getPath() {
            return path;
        }
    }
}
