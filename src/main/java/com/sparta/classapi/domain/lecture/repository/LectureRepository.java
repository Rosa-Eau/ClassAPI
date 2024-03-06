package com.sparta.classapi.domain.lecture.repository;

import com.sparta.classapi.domain.lecture.entity.lecture.Category;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long>{


    List<Lecture> findByCategoryOrderByNameDesc(Category categoryEnum);

    List<Lecture> findByCategoryOrderByCostDesc(Category categoryEnum);

    List<Lecture> findByCategoryOrderByRegisteredAtDesc(Category categoryEnum);


    List<Lecture> findByCategoryOrderByNameAsc(Category categoryEnum);

    List<Lecture> findByCategoryOrderByCostAsc(Category categoryEnum);

    List<Lecture> findByCategoryOrderByRegisteredAtAsc(Category categoryEnum);

}
