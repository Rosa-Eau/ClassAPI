package com.sparta.classapi.domain.user.controller;

import com.sparta.classapi.domain.user.dto.SignoutRequestDto;
import com.sparta.classapi.domain.user.dto.SignupRequestDto;
import com.sparta.classapi.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "user", description = "회원 관리 API")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "회원가입",
            description = "새로운 사용자를 회원가입합니다."
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public String signup(
            @RequestBody @Valid SignupRequestDto requestDto,
            BindingResult bindingResult) {
        userService.signup(requestDto);
        return "회원가입에 성공하였습니다.";
    }

    @Operation(
            summary = "회원탈퇴",
            description = "현재 사용자를 회원탈퇴합니다."
    )
    @DeleteMapping("/signout")
    public String signout(
            @RequestBody @Valid SignoutRequestDto requestDto) {
        userService.signout(requestDto);
        return "회원을 탈퇴합니다.";
    }
}

