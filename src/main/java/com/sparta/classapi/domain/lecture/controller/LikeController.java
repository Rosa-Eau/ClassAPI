package com.sparta.classapi.domain.lecture.controller;


import com.sparta.classapi.domain.lecture.dto.like.LikeRequestDto;
import com.sparta.classapi.domain.lecture.entity.like.Like;
import com.sparta.classapi.domain.lecture.service.LikeService;
import com.sparta.classapi.global.security.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/like/lecture")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/{lectureId}")
    public ResponseEntity<?> addLike(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable Long lectureId) {
        String email = user.getUsername();
        log.info("email : " + email);
        return ResponseEntity.ok(likeService.addLike(email, lectureId));
    }

}
