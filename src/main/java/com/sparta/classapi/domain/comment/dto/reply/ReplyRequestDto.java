package com.sparta.classapi.domain.comment.dto.reply;


import com.sparta.classapi.domain.comment.entity.comment.Comment;
import com.sparta.classapi.domain.comment.entity.reply.Reply;
import com.sparta.classapi.domain.user.entity.User;
import lombok.Getter;

@Getter
public class ReplyRequestDto {

    private Long userId;
    private String content;

    public Reply toEntity(User user, Comment comment) {
        return Reply.builder()
                .content(content)
                .user(user)
                .comment(comment)
                .build();
    }
}
