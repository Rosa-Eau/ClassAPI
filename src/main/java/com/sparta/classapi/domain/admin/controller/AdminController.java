package com.sparta.classapi.domain.admin.controller;


import com.sparta.classapi.domain.admin.dto.TutorRequestDto;
import com.sparta.classapi.domain.admin.dto.TutorResponseDto;
import com.sparta.classapi.domain.admin.service.AdminService;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureCreateResponseDto;
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
    public TutorResponseDto createTutor(@Valid @RequestBody TutorRequestDto requestDto, BindingResult bindingResult) {
            return adminService.registerTutor(requestDto);
    }

    @Tag(name = "registerLecture", description = "강의 등록")
    @PostMapping("/lecture")
    public LectureCreateResponseDto createLecture(@Valid @RequestBody LectureRequestDto requestDto, BindingResult bindingResult) {
            return adminService.registerLecture(requestDto);
    }

}
