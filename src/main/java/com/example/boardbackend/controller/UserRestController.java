package com.example.boardbackend.controller;

import com.example.boardbackend.payroad.joinMemberRequest;
import com.example.boardbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserRestController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> joinMember(@RequestBody joinMemberRequest joinMemberRequest) {
        return ResponseEntity.ok().body(userService.joinMember(joinMemberRequest));
    }

    @GetMapping("/signup-check/{userEmail}")
    public ResponseEntity<Boolean> checkEmail(@PathVariable String userEmail) {
        return ResponseEntity.ok().body(userService.checkEmail(userEmail));
    }

}
