package com.sparta.classapi.domain.user.dto;

import lombok.Getter;

@Getter
public class SignoutRequestDto {

    private Long id;
    private String email;
    private String password;

    public SignoutRequestDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
