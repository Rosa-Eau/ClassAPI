package com.sparta.classapi.domain.lecture.dto.lecture;


import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LectureListResponseDto {

    private String name;

    private int cost;

    private String description;

    private String category;

    private LocalDateTime registeredAt;

    public LectureListResponseDto(Lecture lecture) {
        this.name = lecture.getName();
        this.cost = lecture.getCost();
        this.category = String.valueOf(lecture.getCategory());
        this.description = lecture.getDescription();
        this.registeredAt = lecture.getRegisteredAt();
    }
}
