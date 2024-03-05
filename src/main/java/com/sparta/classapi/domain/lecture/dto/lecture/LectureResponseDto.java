package com.sparta.classapi.domain.lecture.dto.lecture;

import com.sparta.classapi.domain.lecture.entity.comment.Comment;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LectureResponseDto {
    private String name;

    private int cost;

    private String description;

    private String category;

    private LocalDateTime registeredAt;

    private Long tutorId;

    private List<Comment> commentList = new ArrayList<>();

    public LectureResponseDto(Lecture lecture) {
        this.name = lecture.getName();
        this.cost = lecture.getCost();
        this.description = lecture.getDescription();
        this.category = lecture.getCategory().getCategory();
        this.registeredAt = lecture.getRegisteredAt();
        this.tutorId = lecture.getTutor().getId();
        this.commentList = lecture.getCommentList();
    }
}
