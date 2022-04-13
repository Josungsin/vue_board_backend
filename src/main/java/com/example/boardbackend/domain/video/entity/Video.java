package com.example.boardbackend.domain.video.entity;

import com.example.boardbackend.domain.SaveTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "video")
public class Video extends SaveTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "video_url")
    private String videoUrl;

    @Builder
    public Video(Long idx, String videoUrl) {
        this.idx = idx;
        this.videoUrl = videoUrl;
    }

}
