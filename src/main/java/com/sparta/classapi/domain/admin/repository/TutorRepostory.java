package com.sparta.classapi.domain.admin.repository;

import com.sparta.classapi.domain.admin.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepostory extends JpaRepository<Tutor, Long> {
}
