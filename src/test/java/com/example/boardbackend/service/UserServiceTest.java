package com.example.boardbackend.service;

import com.example.boardbackend.Exception.BadRequestException;
import com.example.boardbackend.domain.user.UserRepository;
import com.example.boardbackend.domain.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void optional_test() {
        String email = "sungsin1030@naver.com";

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            System.out.println("이미 존재하는 이메일");
        } else
            System.out.println("사용 가능한 이메일!");
    }

    @Test
    void optional_test2() {
        Long idx = 4L;

        userRepository.findById(idx).ifPresent(a -> {
            throw new BadRequestException("이미 존재함!!");
        });

        System.out.println("없음!");
    }

}