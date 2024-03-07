package com.sparta.classapi.domain.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class SignoutRequestDto {

    @Schema(description = "사용자 ID", example = "1")
    private Long id;

    @Schema(description = "사용자 이메일", example = "user@example.com")
    private String email;

    @Schema(description = "사용자 비밀번호")
    private String password;

    public SignoutRequestDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
