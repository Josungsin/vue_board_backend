package com.example.boardbackend.payroad;

import lombok.Getter;

@Getter
public class BoardRequest {

    private String userName;

    private String title;

    private String content;

    private Long categoryIdx;

}
