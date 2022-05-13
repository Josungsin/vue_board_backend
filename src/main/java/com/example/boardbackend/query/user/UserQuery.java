package com.example.boardbackend.query.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.example.boardbackend.domain.user.entity.QUser.user;

@Repository
public class UserQuery extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public UserQuery(JPAQueryFactory jpaQueryFactory) {
        super(UserQuery.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public boolean findUserId(String userId) {
        return from(user)
                .where(user.userId.eq(userId))
                .select(user.userId)
                .fetchFirst() != null;
    }

}
