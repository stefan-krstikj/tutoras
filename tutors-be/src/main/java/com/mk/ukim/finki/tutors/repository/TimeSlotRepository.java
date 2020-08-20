package com.mk.ukim.finki.tutors.repository;

import com.mk.ukim.finki.tutors.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    TimeSlot findByStartTime(LocalDateTime startTime);
    TimeSlot findById(Integer id);
}
