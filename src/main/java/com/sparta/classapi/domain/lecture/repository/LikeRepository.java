package com.sparta.classapi.domain.lecture.repository;

import com.sparta.classapi.domain.lecture.entity.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    int countByLectureId(Long lectureId);

    boolean existsByLectureIdAndUserId(Long lectureId, Long id);

    void deleteByLectureIdAndUserId(Long lectureId, Long id);
}
