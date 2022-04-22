package com.example.boardbackend.service;

import com.example.boardbackend.Exception.BadRequestException;
import com.example.boardbackend.domain.user.UserRepository;
import com.example.boardbackend.domain.user.entity.User;
import com.example.boardbackend.payroad.joinMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long joinMember(joinMemberRequest joinMemberRequest) {

        User user = User.builder()
                .email(joinMemberRequest.getEmail())
                .userName(joinMemberRequest.getUserName())
                .password(joinMemberRequest.getPassword())
                .build();
        userRepository.save(user);

        return user.getIdx();
    }

    @Transactional
    public Boolean checkEmail(String userEmail) {
        Optional<User> user = userRepository.findByEmail(userEmail);
        if (user != null) {
            throw new BadRequestException("이미 사용중인 이메일 입니다.");
        }
        return true;
    }
}
