package com.sparta.everydrink.domain.liked.dto;

import com.sparta.everydrink.domain.comment.dto.CommentResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LikedCommentsResponseDto {
    private List<CommentResponseDto> likedComments;
    private int totalPages;
    private long totalElements;

    public LikedCommentsResponseDto(List<CommentResponseDto> likedComments, int totalPages, long totalElements){
        this.likedComments = likedComments;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
}
