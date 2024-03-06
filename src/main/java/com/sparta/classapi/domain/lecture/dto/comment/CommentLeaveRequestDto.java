package com.sparta.classapi.domain.lecture.dto.comment;


import com.sparta.classapi.domain.admin.entity.Tutor;
import com.sparta.classapi.domain.lecture.entity.comment.Comment;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

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
