package com.sparta.classapi.domain.comment.repository;

import com.sparta.classapi.domain.comment.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByLectureId(Long lectureId);

    Comment findByLectureIdAndUserId(Long lectureId, Long userId);

    boolean existsByLectureIdAndUserId(Long lectureId, Long userId);

    boolean existsByIdAndUserId(Long commentId, Long id);
}
