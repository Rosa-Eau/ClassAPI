package com.sparta.classapi.domain.comment.dto.comment;


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
