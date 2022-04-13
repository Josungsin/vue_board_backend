package com.example.boardbackend.domain.board.entity;

import com.example.boardbackend.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false)
    private User userIdx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @Column(name = "mod_date")
    private LocalDateTime modDate;

    @Builder
    public Board(Long idx, User userIdx, String title, String content, LocalDateTime regDate, LocalDateTime modDate) {
        this.idx = idx;
        this.userIdx = userIdx;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
