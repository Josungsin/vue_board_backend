package com.example.boardbackend.service;

import com.example.boardbackend.config.SecurityConfig;
import com.example.boardbackend.domain.user.UserRepository;
import com.example.boardbackend.domain.user.entity.User;
import com.example.boardbackend.exception.BadRequestException;
import com.example.boardbackend.payroad.joinMemberRequest;
import com.example.boardbackend.query.user.UserQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserQuery userQuery;
    private final SecurityConfig securityConfig;

    @Transactional
    public Long joinMember(joinMemberRequest joinMemberRequest) {

        User user = User.builder()
                .userId(joinMemberRequest.getUserId())
                .email(joinMemberRequest.getEmail())
                .userName(joinMemberRequest.getUserName())
                .password(securityConfig.passwordEncoder().encode(joinMemberRequest.getPassword()))
                .build();
        userRepository.save(user);

        return user.getIdx();
    }

    @Transactional
    public int checkUserId(String userId) {
        if (userQuery.findUserId(userId)) {
            throw new BadRequestException("이미 사용즁인 아이디 입니다.");
        }
        return 1;
    }
}
