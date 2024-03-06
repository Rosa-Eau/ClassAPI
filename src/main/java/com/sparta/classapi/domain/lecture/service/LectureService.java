package com.sparta.classapi.domain.lecture.service;

import com.sparta.classapi.domain.admin.dto.TutorToLectureResponseDto;
import com.sparta.classapi.domain.lecture.dto.comment.CommentToLectureResponseDto;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureListResponseDto;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureResponseDto;
import com.sparta.classapi.domain.lecture.entity.comment.Comment;
import com.sparta.classapi.domain.lecture.entity.lecture.Category;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.lecture.repository.CommentRepository;
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

    public LectureService(LectureRepository lectureRepository, CommentRepository commentRepository, LikeRepository likeRepository) {
        this.lectureRepository = lectureRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
    }

    @Transactional(readOnly = true)
    public LectureResponseDto readLecture(Long lectureId) {

        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() -> new IllegalArgumentException("등록되지 않은 강의입니다."));

        List<Comment> comments = commentRepository.findByLectureId(lectureId);

        List<CommentToLectureResponseDto> commentsToLecture = comments.stream().map(CommentToLectureResponseDto::new).collect(Collectors.toList());

        int likes = likeRepository.countByLectureId(lectureId);

        return new LectureResponseDto(lecture, likes, new TutorToLectureResponseDto(lecture.getTutor()), commentsToLecture);
    }


    @Transactional(readOnly = true)
    public List<LectureListResponseDto> readLectureList(String category, String select, String sort) {

        Category categoryEnum = Category.valueOf(category);

        if (sort.equals("desc")) {
            if (select.equals("name")) {
                List<Lecture> lectures = lectureRepository.findByCategoryOrderByNameDesc(categoryEnum);
                return lectures.stream().map(LectureListResponseDto::new).collect(Collectors.toList());
            }

            if (select.equals("cost")) {
                List<Lecture> lectures = lectureRepository.findByCategoryOrderByCostDesc(categoryEnum);
                return lectures.stream().map(LectureListResponseDto::new).collect(Collectors.toList());
            }

            if (select.equals("registeredAt")) {
                List<Lecture> lectures = lectureRepository.findByCategoryOrderByRegisteredAtDesc(categoryEnum);
                return lectures.stream().map(LectureListResponseDto::new).collect(Collectors.toList());
            }

        }

        if (sort.equals("asc")) {
            if (select.equals("name")) {
                List<Lecture> lectures = lectureRepository.findByCategoryOrderByNameAsc(categoryEnum);
                return lectures.stream().map(LectureListResponseDto::new).collect(Collectors.toList());
            }

            if (select.equals("cost")) {
                List<Lecture> lectures = lectureRepository.findByCategoryOrderByCostAsc(categoryEnum);
                return lectures.stream().map(LectureListResponseDto::new).collect(Collectors.toList());
            }

            if (select.equals("registeredAt")) {
                List<Lecture> lectures = lectureRepository.findByCategoryOrderByRegisteredAtAsc(categoryEnum);
                return lectures.stream().map(LectureListResponseDto::new).collect(Collectors.toList());
            }
        }

        throw new IllegalArgumentException("선택사항이 잘못되었습니다.");
    }
}
