package com.sparta.classapi.domain.lecture.controller;


import com.sparta.classapi.domain.lecture.service.LectureService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lecture")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Tag(name = "readLecture", description = "선택 강의 조회")
    @GetMapping("/{lectureId}")
    public ResponseEntity<?> readLecture(@PathVariable Long lectureId) {
        try {
            return ResponseEntity.ok(lectureService.readLecture(lectureId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> readLectureList(@RequestParam String category, String select, String sort) {
        try {
            return ResponseEntity.ok(lectureService.readLectureList(category, select, sort));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
