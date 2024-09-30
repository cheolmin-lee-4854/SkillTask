package com.auth.domain.schedule.repository;

import com.auth.domain.schedule.entity.Schedule;
import com.auth.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<User> findByUsername(String username);

}
