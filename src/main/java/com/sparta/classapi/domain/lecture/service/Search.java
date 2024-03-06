package com.sparta.classapi.domain.lecture.service;

import com.sparta.classapi.domain.lecture.dto.lecture.LectureListResponseDto;
import com.sparta.classapi.domain.lecture.entity.lecture.Category;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.lecture.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Search {

    private final LectureRepository lectureRepository;

    public Search(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<LectureListResponseDto> desc(Category categoryEnum, String select) {

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

        throw new IllegalArgumentException("선택사항이 잘못되었습니다.");
    }

    public List<LectureListResponseDto> asc(Category categoryEnum, String select) {

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

        throw new IllegalArgumentException("선택사항이 잘못되었습니다.");
    }
}
