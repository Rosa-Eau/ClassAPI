package com.sparta.classapi.domain.comment.dto.comment;

import com.sparta.classapi.domain.comment.entity.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentToLectureResponseDto {
    private String email;

    private String content;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    public CommentToLectureResponseDto(Comment comment) {
        this.email = comment.getUser().getEmail();
        this.content = comment.getContent();
        this.registeredAt = comment.getRegisteredAt();
        this.updatedAt = comment.getUpdatedAt();
    }

}
