package com.example.boardbackend.payroad;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardListResponse {

    private Long idx;

    private String userEmail;

    private String title;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime regDate;

}
