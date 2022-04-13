package com.example.boardbackend.service;

import com.example.boardbackend.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void checkEmail() {
        String email = "sungsin1030@naver.com";

        userRepository.findByEmail(email);

    }
}