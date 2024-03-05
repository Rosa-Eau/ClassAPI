package com.sparta.classapi.domain.user.service;

import com.sparta.classapi.domain.user.dto.SignupRequestDto;
import com.sparta.classapi.domain.user.entity.UserRoleEnum;
import com.sparta.classapi.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final String ADMIN_TOKEN = "7870ba8089050930cdd1e2616e842ff76b0880770ad04798dd947226e9ef90234709ff5d64533b36556b31ec8cc001ff17d9be9ac469f03ad10efac8560b40ea";

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void signup(SignupRequestDto requestDto) {
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        // 회원 중복 확인
        if(userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("중복된 이메일이 존재합니다.");
        }

        log.info("admin? : " + requestDto.isAdmin());

        UserRoleEnum auth = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            log.info(requestDto.getAdminToken());
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            auth = UserRoleEnum.ADMIN;
        }

        // 사용자 등록
        userRepository.save(requestDto.toEntity(encodedPassword, auth));
    }
}