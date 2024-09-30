package com.auth.domain.schedule.service;

import com.auth.config.JwtUtil;
import com.auth.domain.schedule.dto.ScheduleRequestDto;
import com.auth.domain.schedule.entity.Schedule;
import com.auth.domain.schedule.repository.ScheduleRepository;
import com.auth.domain.user.entity.User;
import com.auth.domain.user.repository.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository, JwtUtil jwtUtil){
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String createSchedule(ScheduleRequestDto requestDto, String token) {
        // JWT 토큰에서 사용자 정보 가져오기
        String email = jwtUtil.getEmailFromToken(token.replace("Bearer ", ""));
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        // Schedule 객체 생성 및 정보 설정
        Schedule schedule = new Schedule();
        schedule.setTitle(requestDto.getTitle());
        schedule.setDescription(requestDto.getDescription());
        schedule.setPlanStartTime(requestDto.getPlanStartTime());
        schedule.setPlanEndTime(requestDto.getPlanEndTime());
        schedule.setUpdatePassword(requestDto.getUpdatePassword());
        schedule.setUser(user); // User 엔티티 추가

        scheduleRepository.save(schedule);
    }

}
