package com.sparta.everydrink.domain.liked.dto;

import com.sparta.everydrink.domain.post.dto.PostResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LikedPostsResponseDto {
    private List<PostResponseDto> likedPosts;
    private int totalPages;
    private long totalElements;

    public LikedPostsResponseDto(List<PostResponseDto> likedPosts, int totalPages, long totalElements) {
        this.likedPosts = likedPosts;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
}
