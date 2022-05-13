package com.example.boardbackend.service;

import com.example.boardbackend.domain.board.BoardCategoryRepository;
import com.example.boardbackend.domain.user.UserRepository;
import com.example.boardbackend.query.user.UserQuery;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.boardbackend.domain.board.entity.QBoardCategory.boardCategory;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardCategoryRepository boardCategoryRepository;

    @Autowired
    private UserQuery userQuery;

    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    @Test
    void password_test(){
        String password = "123456789";
        String password2 = "123456789324242423";

        String encodePassword = passwordEncoder.encode(password);

        boolean check = passwordEncoder.matches(password, encodePassword);
        boolean check2 = passwordEncoder.matches(password2, encodePassword);
    }

}