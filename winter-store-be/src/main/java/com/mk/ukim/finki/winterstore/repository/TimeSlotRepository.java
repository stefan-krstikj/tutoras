package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    TimeSlot findByStartTime(LocalDateTime startTime);

}
