package com.example.boardbackend.service;

import com.example.boardbackend.domain.video.VideoRepository;
import com.example.boardbackend.domain.video.entity.Video;
import com.example.boardbackend.payroad.VideoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    @Transactional
    public Long saveVideo(VideoRequest videoRequest){

        Video video = Video.builder()
                .videoUrl(videoRequest.getVideoUrl())
                .build();
        videoRepository.save(video);

        return video.getIdx();
    }
}
