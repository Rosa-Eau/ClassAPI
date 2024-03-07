package com.sparta.classapi.domain.comment.service;


import com.sparta.classapi.domain.comment.dto.comment.CommentLeaveRequestDto;
import com.sparta.classapi.domain.comment.dto.comment.CommentUpdateRequestDto;
import com.sparta.classapi.domain.comment.entity.comment.Comment;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.comment.repository.CommentRepository;
import com.sparta.classapi.domain.lecture.repository.LectureRepository;
import com.sparta.classapi.domain.user.entity.User;
import com.sparta.classapi.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, LectureRepository lectureRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.lectureRepository = lectureRepository;
    }

    @Transactional
    public void leaveComment(CommentLeaveRequestDto requestDto, String email) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new NullPointerException("해당 유저를 찾을 수 없습니다."));

        Lecture lecture = lectureRepository.findById(requestDto.getLectureId()).orElseThrow(() -> new NullPointerException("해당 강의를 찾을 수 없습니다."));

        commentRepository.save(requestDto.toEntity(user, lecture));
    }

    @Transactional
    public void updateComment(CommentUpdateRequestDto requestDto, String email, Long commentId) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new NullPointerException("해당 유저를 찾을 수 없습니다."));

        if (!commentRepository.existsByLectureIdAndUserId(requestDto.getLectureId(), user.getId())) {
            throw  new IllegalArgumentException("해당 댓글을 등록한 회원만 댓글 수정이 가능합니다.");
        }

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("해당 댓글을 찾을 수 없습니다."));

        comment.update(requestDto);
    }

    @Transactional
    public void deleteComment(Long commentId, String email) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new NullPointerException("해당 유저를 찾을 수 없습니다."));

        if (!commentRepository.existsByIdAndUserId(commentId, user.getId())) {
            throw  new IllegalArgumentException("해당 댓글을 등록한 회원만 댓글 삭제가 가능합니다.");
        }

        commentRepository.deleteById(commentId);

    }

}
