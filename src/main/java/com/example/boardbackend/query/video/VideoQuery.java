package com.example.boardbackend.query.video;

import com.example.boardbackend.payroad.VideoResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.boardbackend.domain.video.entity.QVideo.video;

@Repository
public class VideoQuery extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public VideoQuery(JPAQueryFactory jpaQueryFactory) {
        super(VideoQuery.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<VideoResponse> findVideo() {

        List<VideoResponse> query = jpaQueryFactory
                .select(Projections.fields(VideoResponse.class,
                        video.idx,
                        video.videoUrl
                ))
                .from(video)
                .fetch();

        return query;
    }
}
