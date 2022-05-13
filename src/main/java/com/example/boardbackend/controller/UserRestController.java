package com.example.boardbackend.controller;

import com.example.boardbackend.payroad.LoginRequest;
import com.example.boardbackend.payroad.joinMemberRequest;
import com.example.boardbackend.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "User-Controller")
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserRestController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> joinMember(@RequestBody @Valid joinMemberRequest joinMemberRequest) {
        return ResponseEntity.ok().body(userService.joinMember(joinMemberRequest));
    }

    @GetMapping("/signup-check")
    public ResponseEntity<Integer> checkEmail(@RequestParam(required = false) String userId) {
        return ResponseEntity.ok().body(userService.checkUserId(userId));
    }

    @GetMapping("/login")
    public boolean login(@RequestBody @Valid LoginRequest LoginRequest) {


        return true;
    }

}
