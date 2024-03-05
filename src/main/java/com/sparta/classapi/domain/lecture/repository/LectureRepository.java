package com.sparta.classapi.domain.lecture.repository;

import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long>{



}
