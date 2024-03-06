package com.sparta.classapi.domain.lecture.dto.comment;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentUpdateRequestDto {

    private Long id;

    private String content;

    private Long lectureId;

    private Long userId;

    private LocalDateTime registeredAt;

}
