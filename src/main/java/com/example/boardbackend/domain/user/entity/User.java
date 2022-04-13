package com.example.boardbackend.domain.user.entity;

import com.example.boardbackend.domain.SaveTimeEntity;
import com.example.boardbackend.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends SaveTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Builder
    public User(Long idx, String email, String userName, String password) {
        this.idx = idx;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();
}
