package com.sparta.classapi.domain.user.controller;

import com.sparta.classapi.domain.user.dto.SignoutRequestDto;
import com.sparta.classapi.domain.user.dto.SignupRequestDto;
import com.sparta.classapi.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public String signup(@RequestBody @Valid SignupRequestDto requestDto, BindingResult bindingResult) {
        userService.signup(requestDto);
        return "회원가입에 성공하였습니다.";
    }

    @DeleteMapping("/signout")
    public String signout(@RequestBody SignoutRequestDto requestDto) {
        userService.signout(requestDto);
        return "회원을 탈퇴합니다.";
    }
}
