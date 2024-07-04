package com.sparta.everydrink.domain.liked.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.everydrink.domain.liked.entity.ContentsTypeEnum;
import com.sparta.everydrink.domain.liked.entity.QLiked;
import com.sparta.everydrink.domain.post.dto.PostResponseDto;
import com.sparta.everydrink.domain.post.entity.Post;
import com.sparta.everydrink.domain.post.entity.QPost;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LikedRepositoryCustomImpl implements LikedRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<PostResponseDto> findLikedPostsByUserId(Long userId, Pageable pageable) {
        QLiked liked = QLiked.liked;
        QPost post = QPost.post;

        List<PostResponseDto> likedPosts = queryFactory
                .select(Projections.constructor(PostResponseDto.class,
                        post.id,
                        post.title,
                        post.content,
                        post.likeCount,
                        post.user.username,
                        post.createdAt,
                        post.modifiedAt))
                .from(liked)
                .join(post).on(liked.contentsId.eq(post.id))
                .where(liked.user.id.eq(userId).and(liked.contentsType.eq(ContentsTypeEnum.POST)))
                .orderBy(post.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.selectFrom(liked)
                .where(liked.user.id.eq(userId).and(liked.contentsType.eq(ContentsTypeEnum.POST)))
                .fetchCount();
        return new PageImpl<>(likedPosts,pageable,total);
    }
}

