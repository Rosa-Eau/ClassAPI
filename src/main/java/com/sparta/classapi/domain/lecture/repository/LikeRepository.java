package com.sparta.classapi.domain.lecture.repository;

import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.lecture.entity.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByLectureId(Long lectureId);

    void deleteByLectureId(Long lectureId);

    int countByLectureId(Long lectureId);
}
