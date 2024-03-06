package com.sparta.classapi.domain.admin.dto;

import com.sparta.classapi.domain.admin.entity.Tutor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TutorToLectureResponseDto {
    private String name;

    private int career;

    private String company;

    private String description;

    public TutorToLectureResponseDto(Tutor tutor) {
        this.name = tutor.getName();
        this.career = tutor.getCareer();
        this.company = tutor.getCompany();
        this.description = tutor.getDescription();
    }
}
