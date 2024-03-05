package com.sparta.classapi.domain.admin.controller;


import com.sparta.classapi.domain.admin.dto.TutorRequestDto;
import com.sparta.classapi.domain.admin.service.AdminService;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureRequestDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Tag(name = "registerTutor", description = "강의 등록")
    @PostMapping("/tutor")
    public ResponseEntity<?> createTutor(@Valid @RequestBody TutorRequestDto requestDto, BindingResult bindingResult) {
        try {
            return ResponseEntity.ok(adminService.registerTutor(requestDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Tag(name = "registerLecture", description = "강의 등록")
    @PostMapping("/lecture")
    public ResponseEntity<?> createLecture(@Valid @RequestBody LectureRequestDto requestDto, BindingResult bindingResult) {
        try {
            return ResponseEntity.ok(adminService.registerLecture(requestDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
