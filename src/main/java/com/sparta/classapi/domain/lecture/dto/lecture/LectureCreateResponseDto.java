package com.sparta.classapi.domain.lecture.dto.lecture;

import com.sparta.classapi.domain.admin.dto.TutorToLectureResponseDto;
import com.sparta.classapi.domain.admin.entity.Tutor;
import com.sparta.classapi.domain.lecture.entity.comment.Comment;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class LectureCreateResponseDto {

    private String name;

    private int cost;

    private String description;

    private String category;

    private LocalDateTime registeredAt;

    private String tutor;

    public LectureCreateResponseDto(Lecture lecture) {
        this.name = lecture.getName();
        this.cost = lecture.getCost();
        this.description = lecture.getDescription();
        this.category = String.valueOf(lecture.getCategory());
        this.registeredAt = lecture.getRegisteredAt();
        this.tutor = lecture.getTutor().getName();
    }
}
