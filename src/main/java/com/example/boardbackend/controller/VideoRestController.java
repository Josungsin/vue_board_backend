package com.example.boardbackend.controller;

import com.example.boardbackend.payroad.VideoRequest;
import com.example.boardbackend.payroad.VideoResponse;
import com.example.boardbackend.query.video.VideoQuery;
import com.example.boardbackend.service.VideoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Video-Controller")
@RequiredArgsConstructor
@RequestMapping("/api/video")
@RestController
public class VideoRestController {

    private final VideoService videoService;
    private final VideoQuery videoQuery;

    @PostMapping("/save")
    public ResponseEntity<Object> saveVideo(@RequestBody VideoRequest videoRequest){
        return ResponseEntity.ok().body(videoService.saveVideo(videoRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<List<VideoResponse>> findVideo(){
        return ResponseEntity.ok().body(videoQuery.findVideo());
    }

}
