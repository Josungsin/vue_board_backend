package com.example.boardbackend.service;

import com.example.boardbackend.payroad.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Transactional
    public Long saveBoard(BoardRequest boardRequest){
        return null;
    }

}
