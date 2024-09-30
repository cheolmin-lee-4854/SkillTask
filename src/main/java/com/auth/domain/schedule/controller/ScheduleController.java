package com.auth.domain.schedule.controller;

import com.auth.domain.schedule.dto.ScheduleRequestDto;
import com.auth.domain.schedule.entity.Schedule;
import com.auth.domain.schedule.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public String createSchedule(@RequestBody ScheduleRequestDto requestDto, HttpServletRequest request) {
        // Authorization 헤더에서 토큰 가져오기
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            return scheduleService.createSchedule(requestDto, token);
        } else {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }
    }

}
