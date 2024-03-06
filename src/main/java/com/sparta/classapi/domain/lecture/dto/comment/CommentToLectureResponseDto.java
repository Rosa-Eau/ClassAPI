package com.sparta.classapi.domain.lecture.dto.comment;

import com.sparta.classapi.domain.lecture.entity.comment.Comment;
import lombok.Getter;

@Getter
public class CommentToLectureResponseDto {
    private String email;

    private String content;

    public CommentToLectureResponseDto(Comment comment) {
        this.email = comment.getUser().getEmail();
        this.content = comment.getContent();
    }

}
