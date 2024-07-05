package com.sparta.everydrink.domain.liked.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.everydrink.domain.comment.dto.CommentResponseDto;
import com.sparta.everydrink.domain.comment.entity.QComment;
import com.sparta.everydrink.domain.liked.entity.ContentsTypeEnum;
import com.sparta.everydrink.domain.liked.entity.QLiked;
import com.sparta.everydrink.domain.post.dto.PostResponseDto;
import com.sparta.everydrink.domain.post.entity.QPost;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
        return new PageImpl<>(likedPosts, pageable, total);
    }

    @Override
    public Page<CommentResponseDto> findLikedCommentsByUserId(Long userId, Pageable pageable) {
        QLiked liked = QLiked.liked;
        QComment comment = QComment.comment;

        List<CommentResponseDto> likedComments = queryFactory
                .select(Projections.constructor(CommentResponseDto.class,
                        comment.id,
                        comment.content,
                        comment.createdAt,
                        comment.modifiedAt,
                        comment.likeCount))
                .from(liked)
                .join(comment).on(liked.contentsId.eq(comment.id))
                .where(liked.user.id.eq(userId).and(liked.contentsType.eq(ContentsTypeEnum.COMMENT)))
                .orderBy(comment.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.selectFrom(liked)
                .where(liked.user.id.eq(userId).and(liked.contentsType.eq(ContentsTypeEnum.COMMENT)))
                .fetchCount();
        return new PageImpl<>(likedComments, pageable, total);
    }

    @Override
    public long countByUserIdAndContentsType(Long userId, ContentsTypeEnum contentsType) {
        QLiked liked = QLiked.liked;
        return queryFactory
                .selectFrom(liked)
                .where(liked.user.id.eq(userId).and(liked.contentsType.eq(contentsType)))
                .fetchCount();
    }
}
