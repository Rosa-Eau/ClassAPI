package com.sparta.classapi.domain.comment.controller;


import com.sparta.classapi.domain.comment.dto.reply.ReplyRequestDto;
import com.sparta.classapi.domain.comment.service.ReplyService;
import com.sparta.classapi.global.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@Tag(name = "reply", description = "대댓글 관리 API")
public class ReplyController {

    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @Operation(
            summary = "대댓글 등록",
            description = "대댓글을 등록합니다(해당 기능은 사용자만 가능합니다)."
    )
    @PostMapping("/{commentId}")
    public String leaveReply(@AuthenticationPrincipal UserDetailsImpl userDetails,
                             @PathVariable Long commentId,
                             @RequestBody ReplyRequestDto requestDto) {

        String email = userDetails.getUsername();
        replyService.leaveReply(email, commentId, requestDto);
        return "대댓글을 등록하였습니다.";
    }
}
