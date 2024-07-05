package com.sparta.everydrink.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.everydrink.domain.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;


    private Long likeCount;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getModifiedAt();
        this.likeCount = comment.getLikeCount();
    }

    public CommentResponseDto(Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt, Long likeCount){
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.likeCount = likeCount;
    }
}
