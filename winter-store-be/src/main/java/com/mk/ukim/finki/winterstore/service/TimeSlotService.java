package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.TimeSlot;

import java.time.LocalDateTime;

public interface TimeSlotService {
    TimeSlot findByStartTime(LocalDateTime startTime);
}
