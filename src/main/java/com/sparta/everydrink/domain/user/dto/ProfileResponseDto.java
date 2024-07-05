package com.sparta.everydrink.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileResponseDto {


    private String username;
    private String nickname;
    private long likedPostCount;
    private long likedCommentCount;


    public ProfileResponseDto(String username, String nickname, long likedPostCount, long likedCommentCount) {
        this.username = username;
        this.nickname = nickname;
        this.likedPostCount = likedPostCount;
        this.likedCommentCount = likedCommentCount;
    }
}
