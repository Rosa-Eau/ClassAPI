package com.sparta.classapi.domain.admin.dto;

import com.sparta.classapi.domain.admin.entity.Tutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class TutorRequestDto {

    private String name;

    private int career;

    private String company;

    @Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$")
    private String phoneNumber;

    private String description;

    public Tutor toEntity() {
        return Tutor.builder()
                .name(this.name)
                .career(this.career)
                .company(this.company)
                .phoneNumber(this.phoneNumber)
                .description(this.description)
                .build();
    }
}
