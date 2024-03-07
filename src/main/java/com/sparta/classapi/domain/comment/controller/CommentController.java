package com.sparta.classapi.domain.comment.controller;

import com.sparta.classapi.domain.comment.dto.comment.CommentLeaveRequestDto;
import com.sparta.classapi.domain.comment.dto.comment.CommentUpdateRequestDto;
import com.sparta.classapi.domain.comment.service.CommentService;
import com.sparta.classapi.global.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
@Tag(name = "comment", description = "댓글 관리 API")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(
            summary = "댓글 등록",
            description = "댓글을 등록합니다(해당 기능은 사용자만 가능합니다)."
    )
    @PostMapping
    public String leaveComment(
            @AuthenticationPrincipal UserDetailsImpl user,
            @RequestBody CommentLeaveRequestDto requestDto) {
        String email = user.getUsername();
        commentService.leaveComment(requestDto, email);
        return "댓글이 등록되었습니다.";
    }

    @Operation(
            summary = "댓글 수정",
            description = "자신이 쓴 댓글을 수정합니다."
    )
    @PutMapping("/{commentId}")
    public String updateComment(
            @AuthenticationPrincipal UserDetailsImpl user,
            @Parameter(description = "댓글의 ID", required = true)
            @PathVariable Long commentId,
            @RequestBody CommentUpdateRequestDto requestDto) {

        String email = user.getUsername();
        commentService.updateComment(requestDto, email, commentId);
        return "댓글이 수정되었습니다.";
    }

    @Operation(
            summary = "댓글 삭제",
            description = "자신이 쓴 댓글을 삭제합니다."
    )
    @DeleteMapping("/{commentId}")
    public String deleteComment(
            @AuthenticationPrincipal UserDetailsImpl user,
            @Parameter(description = "댓글의 ID", required = true)
            @PathVariable Long commentId) {

        String email = user.getUsername();
        commentService.deleteComment(commentId, email);
        return "댓글이 삭제되었습니다.";
    }
}