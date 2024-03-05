package com.sparta.classapi.domain.lecture.entity.lecture;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Category {
    NODE("NODE"), REACT("REACT"), SPRING("SPRING");

    @JsonValue
    private final String category;

    Category(String category) {
        this.category = category;
    }
}