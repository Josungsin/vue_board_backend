package com.example.boardbackend.payroad;

import lombok.Getter;

@Getter
public class BoardRequest {

    private String userEmail;

    private String title;

    private String content;

    private Long categoryIdx;

}
