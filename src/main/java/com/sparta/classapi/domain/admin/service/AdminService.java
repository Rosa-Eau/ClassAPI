package com.sparta.classapi.domain.admin.service;


import com.sparta.classapi.domain.admin.dto.TutorRequestDto;
import com.sparta.classapi.domain.admin.dto.TutorResponseDto;
import com.sparta.classapi.domain.admin.entity.Tutor;
import com.sparta.classapi.domain.admin.repository.TutorRepostory;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureCreateResponseDto;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureRequestDto;
import com.sparta.classapi.domain.lecture.dto.lecture.LectureResponseDto;
import com.sparta.classapi.domain.lecture.entity.lecture.Category;
import com.sparta.classapi.domain.lecture.entity.lecture.Lecture;
import com.sparta.classapi.domain.lecture.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    private final TutorRepostory tutorRepostory;
    private final LectureRepository lectureRepository;

    public AdminService(TutorRepostory tutorRepostory, LectureRepository lectureRepository) {
        this.tutorRepostory = tutorRepostory;
        this.lectureRepository = lectureRepository;
    }

    @Transactional
    public TutorResponseDto registerTutor(TutorRequestDto requestDto) {

        Tutor tutor = tutorRepostory.save(requestDto.toEntity());

        return new TutorResponseDto(tutor);
    }

    @Transactional
    public LectureCreateResponseDto registerLecture(LectureRequestDto requestDto) {

        Category category = Category.valueOf(requestDto.getCategory());

        Tutor tutor = tutorRepostory.findById(requestDto.getTutorId()).orElseThrow(() -> new NullPointerException("등록되지 않은 강사입니다."));

        Lecture lecture = lectureRepository.save(requestDto.toEntity(tutor, category));

        return new LectureCreateResponseDto(lecture);
    }

}
