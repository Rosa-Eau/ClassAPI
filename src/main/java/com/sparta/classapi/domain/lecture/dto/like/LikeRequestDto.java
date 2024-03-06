package com.sparta.classapi.domain.lecture.dto.like;


import lombok.Getter;

@Getter
public class LikeRequestDto {

    private Long userId;

    private Long lectureId;

//    public Like toEntity(User user, Lecture lecture) {
//        return Like.builder()
//                .user(user)
//                .lecture(lecture)
//                .build();
//    }

}
