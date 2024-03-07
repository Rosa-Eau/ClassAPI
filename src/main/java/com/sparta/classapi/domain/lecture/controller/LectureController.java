package com.sparta.classapi.domain.lecture.controller;


import com.sparta.classapi.domain.lecture.dto.lecture.LectureListResponseDto;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureResponseDto;
import com.sparta.classapi.domain.lecture.service.LectureService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lecture")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Tag(name = "readLecture", description = "선택 강의 조회")
    @GetMapping("/{lectureId}")
    public LectureResponseDto readLecture(@PathVariable Long lectureId) {
        return lectureService.readLecture(lectureId);
    }

    @Tag(name = "readLecture", description = "카테고리별 강의 조희")
    @GetMapping
    public List<LectureListResponseDto> readLectureList(@RequestParam String category, String select, String sort) {
        return lectureService.readLectureList(category, select, sort);
    }
}
