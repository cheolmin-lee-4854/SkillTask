package com.auth.domain.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequestDto {
    private String title;
    private String description;
    private LocalDateTime planStartTime;
    private LocalDateTime planEndTime;
    private String updatePassword;
}
