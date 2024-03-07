package com.sparta.classapi.global.handler.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ValidResponseDto<T> {
    // final 이유 : 응답의 dto는 한번 만들어지면 수정될 이유가 없음.
    private final boolean code;
    private final String msg;
    private final T data;

    public static <T> ValidResponseDto<T> success(String message, T data) {
        return new ValidResponseDto<>(true, message, data);
    }

    public static <T> ValidResponseDto<T> fail(String message) {
        return new ValidResponseDto<>(false, message, null);
    }

    public static <T> ValidResponseDto<T> fail(String message, T data) {
        return new ValidResponseDto<>(false, message, data);
    }
}