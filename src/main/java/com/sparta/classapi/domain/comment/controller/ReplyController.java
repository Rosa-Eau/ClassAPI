package com.sparta.classapi.domain.comment.controller;


import com.sparta.classapi.domain.comment.dto.reply.ReplyRequestDto;
import com.sparta.classapi.domain.comment.service.ReplyService;
import com.sparta.classapi.global.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class ReplyController {

    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/{commentId}")
    public String leaveReply(@AuthenticationPrincipal UserDetailsImpl userDetails,
                             @PathVariable Long commentId,
                             @RequestBody ReplyRequestDto requestDto) {

        String email = userDetails.getUsername();
        replyService.leaveReply(email, commentId, requestDto);
        return "대댓글을 등록하였습니다.";
    }
}
