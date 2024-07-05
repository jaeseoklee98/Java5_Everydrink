package com.sparta.everydrink.domain.liked.entity;

import com.sparta.everydrink.domain.comment.entity.Comment;
import com.sparta.everydrink.domain.common.TimeStampEntity;
import com.sparta.everydrink.domain.post.entity.Post;
import com.sparta.everydrink.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Liked extends TimeStampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "contents_id", nullable = false)
    private Long contentsId;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type", nullable = false)
    private ContentsTypeEnum contentsType;

    public Liked(User user, Post post, Comment comment, Long contentsId, ContentsTypeEnum contentsType) {
        if(post == null && comment == null) {
            throw new IllegalArgumentException("Post와 Comment 중 하나는 반드시 존재해야 합니다.");
        }
        this.user = user;
        this.post = post;
        this.comment = comment;
        this.contentsId = contentsId;
        this.contentsType = contentsType;
    }
}
