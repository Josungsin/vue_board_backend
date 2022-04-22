package com.example.boardbackend.domain.board.entity;

import com.example.boardbackend.domain.SaveTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board extends SaveTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Builder
    public Board(Long idx, String userEmail, String title, String content) {
        this.idx = idx;
        this.userEmail = userEmail;
        this.title = title;
        this.content = content;
    }
}
