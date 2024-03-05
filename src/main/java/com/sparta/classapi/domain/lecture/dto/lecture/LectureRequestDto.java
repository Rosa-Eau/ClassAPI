package com.sparta.classapi.domain.lecture.dto.lecture;

import com.sparta.classapi.domain.admin.entity.Tutor;
import com.sparta.classapi.domain.lecture.entity.lecture.Category;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import lombok.Getter;

@Getter
public class LectureRequestDto {

    private String name;

    private int cost;

    private String description;

    private String category;

    private Long tutorId;

    public Lecture toEntity(Tutor tutor, Category category) {
        return Lecture.builder()
                .name(name)
                .cost(cost)
                .description(description)
                .category(category)
                .tutor(tutor)
                .build();
    }
}
