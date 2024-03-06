package com.sparta.classapi.domain.lecture.controller;

import com.sparta.classapi.domain.lecture.dto.comment.CommentLeaveRequestDto;
import com.sparta.classapi.domain.lecture.dto.comment.CommentUpdateRequestDto;
import com.sparta.classapi.domain.lecture.service.CommentService;
import com.sparta.classapi.global.security.UserDetailsImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> leaveComment(@AuthenticationPrincipal UserDetailsImpl user,
                                          @RequestBody CommentLeaveRequestDto requestDto) {

        String email = user.getUsername();
        try {
            commentService.leaveComment(requestDto, email);
            return ResponseEntity.ok("댓글이 등록되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@AuthenticationPrincipal UserDetailsImpl user,
                                           @PathVariable Long commentId,
                                           @RequestBody CommentUpdateRequestDto requestDto) {

        String email = user.getUsername();
        try {
            commentService.updateComment(requestDto, email, commentId);
            return ResponseEntity.ok("댓글이 수정되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@AuthenticationPrincipal UserDetailsImpl user,
                                           @PathVariable Long commentId) {

        String email = user.getUsername();
        try {
            commentService.deleteComment(commentId, email);
            return ResponseEntity.ok("댓글이 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }



}
