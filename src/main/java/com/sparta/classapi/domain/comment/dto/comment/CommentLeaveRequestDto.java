package com.sparta.classapi.domain.comment.dto.comment;


import com.sparta.classapi.domain.comment.entity.comment.Comment;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.user.entity.User;
import lombok.Getter;

@Getter
public class CommentLeaveRequestDto {

    private String content;

    private Long lectureId;

    public Comment toEntity(User user, Lecture lecture) {
        return Comment.builder()
                .content(content)
                .user(user)
                .lecture(lecture)
                .build();
    }


}
