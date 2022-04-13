package com.example.boardbackend.domain.video;

import com.example.boardbackend.domain.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
