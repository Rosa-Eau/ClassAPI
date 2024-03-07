package com.sparta.classapi.domain.lecture.service;

import com.sparta.classapi.domain.admin.dto.TutorToLectureResponseDto;
import com.sparta.classapi.domain.comment.dto.comment.CommentToLectureResponseDto;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureListResponseDto;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureResponseDto;
import com.sparta.classapi.domain.comment.entity.comment.Comment;
import com.sparta.classapi.domain.lecture.entity.lecture.Category;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.comment.repository.CommentRepository;
import com.sparta.classapi.domain.lecture.repository.LectureRepository;
import com.sparta.classapi.domain.lecture.repository.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final Search search;

    public LectureService(LectureRepository lectureRepository, CommentRepository commentRepository, LikeRepository likeRepository, Search search) {
        this.lectureRepository = lectureRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
        this.search = search;
    }

    @Transactional(readOnly = true)
    public LectureResponseDto readLecture(Long lectureId) {

        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() -> new NullPointerException("등록되지 않은 강의입니다."));

        List<Comment> comments = commentRepository.findByLectureId(lectureId);

        List<CommentToLectureResponseDto> commentsToLecture = comments.stream().map(CommentToLectureResponseDto::new).collect(Collectors.toList());

        int likes = likeRepository.countByLectureId(lectureId);

        return new LectureResponseDto(lecture, likes, new TutorToLectureResponseDto(lecture.getTutor()), commentsToLecture);
    }


    @Transactional(readOnly = true)
    public List<LectureListResponseDto> readLectureList(String category, String select, String sort) {

        Category categoryEnum = Category.valueOf(category);

        if (sort.equals("desc")) {
            return search.desc(categoryEnum, select);
        }

        if (sort.equals("asc")) {
            return search.asc(categoryEnum, select);
        }

        throw new IllegalArgumentException("정렬 선택이 잘못되었습니다.");

    }

}
