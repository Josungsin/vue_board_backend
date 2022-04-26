package com.example.boardbackend.domain.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "board_category")
public class BoardCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "boardCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> board;

    @Builder
    public BoardCategory(Long idx, String categoryName) {
        this.idx = idx;
        this.categoryName = categoryName;
    }
}
