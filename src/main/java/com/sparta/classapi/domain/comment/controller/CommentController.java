package com.sparta.classapi.domain.comment.controller;

import com.sparta.classapi.domain.comment.dto.comment.CommentLeaveRequestDto;
import com.sparta.classapi.domain.comment.dto.comment.CommentUpdateRequestDto;
import com.sparta.classapi.domain.comment.service.CommentService;
import com.sparta.classapi.global.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String leaveComment(@AuthenticationPrincipal UserDetailsImpl user,
                               @RequestBody CommentLeaveRequestDto requestDto) {
        String email = user.getUsername();
        commentService.leaveComment(requestDto, email);
        return "댓글이 등록되었습니다.";
    }

    @PutMapping("/{commentId}")
    public String updateComment(@AuthenticationPrincipal UserDetailsImpl user,
                                @PathVariable Long commentId,
                                @RequestBody CommentUpdateRequestDto requestDto) {

        String email = user.getUsername();
        commentService.updateComment(requestDto, email, commentId);
        return "댓글이 수정되었습니다.";
    }

    @DeleteMapping("/{commentId}")
    public String deleteComment(@AuthenticationPrincipal UserDetailsImpl user,
                                @PathVariable Long commentId) {

        String email = user.getUsername();
        commentService.deleteComment(commentId, email);
        return "댓글이 삭제되었습니다.";

    }


}
