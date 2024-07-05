package com.sparta.everydrink.domain.liked.repository;

import com.sparta.everydrink.domain.comment.dto.CommentResponseDto;
import com.sparta.everydrink.domain.liked.entity.ContentsTypeEnum;
import com.sparta.everydrink.domain.post.dto.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LikedRepositoryCustom {
    Page<PostResponseDto> findLikedPostsByUserId(Long userId, Pageable pageable);

    Page<CommentResponseDto> findLikedCommentsByUserId(Long userId, Pageable pageable);

    long countByUserIdAndContentsType(Long id, ContentsTypeEnum contentsTypeEnum);
}
