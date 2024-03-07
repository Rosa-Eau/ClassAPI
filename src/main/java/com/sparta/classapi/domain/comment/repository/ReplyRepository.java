package com.sparta.classapi.domain.comment.repository;

import com.sparta.classapi.domain.comment.entity.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
