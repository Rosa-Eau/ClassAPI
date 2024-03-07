package com.sparta.classapi.domain.comment.service;

import com.sparta.classapi.domain.comment.dto.reply.ReplyRequestDto;
import com.sparta.classapi.domain.comment.entity.comment.Comment;
import com.sparta.classapi.domain.comment.repository.CommentRepository;
import com.sparta.classapi.domain.comment.repository.ReplyRepository;
import com.sparta.classapi.domain.user.entity.User;
import com.sparta.classapi.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public ReplyService(ReplyRepository replyRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.replyRepository = replyRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void leaveReply(String email, Long commentId, ReplyRequestDto requestDto) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new NullPointerException("해당 유저를 찾을 수 없습니다."));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("해당 댓글을 찾을 수 없습니다."));

        replyRepository.save(requestDto.toEntity(user, comment));
    }
}
