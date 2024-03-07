package com.sparta.classapi.domain.comment.dto.reply;


import lombok.Getter;

@Getter
public class ReplyResponseDto {
    private Long userId;
    private String content;
    private Long commentId;
}
