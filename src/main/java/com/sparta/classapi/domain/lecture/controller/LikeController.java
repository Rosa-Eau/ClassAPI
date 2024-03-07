package com.sparta.classapi.domain.lecture.controller;


import com.sparta.classapi.domain.lecture.dto.like.LikeRequestDto;
import com.sparta.classapi.domain.lecture.entity.like.Like;
import com.sparta.classapi.domain.lecture.service.LikeService;
import com.sparta.classapi.global.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/like/lecture")
@Tag(name = "like", description = "강의에 대한 좋아요 기능 관리 API")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @Operation(
            summary = "강의에 좋아요 추가",
            description = "주어진 강의 ID에 해당하는 강의에 현재 사용자의 좋아요를 추가합니다."
    )
    @PostMapping("/{lectureId}")
    public String addLike(
            @AuthenticationPrincipal UserDetailsImpl user,
            @Parameter(description = "강의의 ID", required = true)
            @PathVariable Long lectureId) {
        String email = user.getUsername();
        return likeService.addLike(email, lectureId);
    }

}
