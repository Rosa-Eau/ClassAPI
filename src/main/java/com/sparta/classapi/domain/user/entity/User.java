package com.sparta.classapi.domain.user.entity;

import com.sparta.classapi.domain.comment.entity.comment.Comment;
import com.sparta.classapi.domain.lecture.entity.like.Like;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String gender;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum auth;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Like> likeList = new ArrayList<>();

}
