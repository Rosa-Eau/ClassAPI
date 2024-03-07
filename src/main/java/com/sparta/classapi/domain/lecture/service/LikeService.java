package com.sparta.classapi.domain.lecture.service;

import com.sparta.classapi.domain.lecture.dto.like.LikeRequestDto;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.lecture.entity.like.Like;
import com.sparta.classapi.domain.lecture.repository.LectureRepository;
import com.sparta.classapi.domain.lecture.repository.LikeRepository;
import com.sparta.classapi.domain.user.entity.User;
import com.sparta.classapi.domain.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@Slf4j
public class LikeService {

    private final LikeRepository likeRepository;
    private final LectureRepository lectureRepository;
    private final UserRepository userRepository;
    private final MessageSource messageSource;

    public LikeService(LikeRepository likeRepository, LectureRepository lectureRepository, UserRepository userRepository, MessageSource messageSource) {
        this.likeRepository = likeRepository;
        this.lectureRepository = lectureRepository;
        this.userRepository = userRepository;
        this.messageSource = messageSource;
    }


    @Transactional
    public String addLike(String email, Long lectureId) {

        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() ->
                new NullPointerException(messageSource.getMessage
                ("해당 강의를 찾을 수 없습니다.",
                null,
                "Not Found Lecture",
                Locale.getDefault())));

        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new NullPointerException("해당 유저를 찾을 수 없습니다."));

        if (likeRepository.existsByLectureId(lectureId)) {
            likeRepository.deleteByLectureId(lectureId);
            return "좋아요를 취소하였습니다.";
        }

        Like like = Like.builder()
                .lecture(lecture)
                .user(user)
                .build();

        likeRepository.save(like);

        return "좋아요를 누르셨습니다.";
    }
}
