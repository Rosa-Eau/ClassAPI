package com.sparta.classapi.domain.lecture.controller;


import com.sparta.classapi.domain.lecture.dto.lecture.LectureListResponseDto;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureResponseDto;
import com.sparta.classapi.domain.lecture.service.LectureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lecture")
@Tag(name = "lecture", description = "강의 정보 관리 API")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Operation(
            summary = "선택 강의 조회",
            description = "주어진 강의 ID에 해당하는 강의를 조회합니다."
    )
    @GetMapping("/{lectureId}")
    public LectureResponseDto readLecture(
            @Parameter(description = "조회할 강의의 ID", required = true)
            @PathVariable Long lectureId) {
        return lectureService.readLecture(lectureId);
    }

    @Operation(
            summary = "카테고리별 강의 조회",
            description = "주어진 카테고리에 해당하는 강의 목록을 조회합니다(조회된 강의 목록은 선택한 기준에 의해 정렬됩니다)."
    )
    @GetMapping
    public List<LectureListResponseDto> readLectureList(
            @Parameter(description = "강의 카테고리", required = true)
            @RequestParam String category,
            @Parameter(description = "조회 옵션")
            @RequestParam(required = false) String select,
            @Parameter(description = "정렬 옵션")
            @RequestParam(required = false) String sort) {
        return lectureService.readLectureList(category, select, sort);
    }
}