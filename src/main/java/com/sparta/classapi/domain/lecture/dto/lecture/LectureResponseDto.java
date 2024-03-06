package com.sparta.classapi.domain.lecture.dto.lecture;

import com.sparta.classapi.domain.admin.dto.TutorToLectureResponseDto;
import com.sparta.classapi.domain.admin.entity.Tutor;
import com.sparta.classapi.domain.lecture.dto.comment.CommentToLectureResponseDto;
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

    private TutorToLectureResponseDto tutor;

    private List<CommentToLectureResponseDto> commentList = new ArrayList<>();

    private int likes;

    public LectureResponseDto(Lecture lecture,
                              int likes,
                              TutorToLectureResponseDto tutor,
                              List<CommentToLectureResponseDto> comments) {
        this.name = lecture.getName();
        this.likes = likes;
        this.cost = lecture.getCost();
        this.description = lecture.getDescription();
        this.category = lecture.getCategory().getCategory();
        this.registeredAt = lecture.getRegisteredAt();
        this.tutor = tutor;
        this.commentList = comments;
    }
}
