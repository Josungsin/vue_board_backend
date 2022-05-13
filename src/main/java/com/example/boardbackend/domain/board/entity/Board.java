package com.example.boardbackend.domain.board.entity;

import com.example.boardbackend.domain.SaveTimeEntity;
import com.example.boardbackend.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board extends SaveTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_idx")
    private BoardCategory boardCategory;

    @Builder
    public Board(Long idx, User user, String title, String content, BoardCategory boardCategory) {
        this.idx = idx;
        this.user = user;
        this.title = title;
        this.content = content;
        this.boardCategory = boardCategory;
    }
}
