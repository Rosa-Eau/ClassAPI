package com.sparta.classapi.domain.comment.entity.comment;


import com.sparta.classapi.domain.comment.dto.comment.CommentUpdateRequestDto;
import com.sparta.classapi.domain.comment.entity.Timestamped;
import com.sparta.classapi.domain.comment.entity.reply.Reply;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comment")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "comment", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Reply> replies = new ArrayList<>();

    public void update(CommentUpdateRequestDto requestDto) {
          this.content = requestDto.getContent();
    }
}
