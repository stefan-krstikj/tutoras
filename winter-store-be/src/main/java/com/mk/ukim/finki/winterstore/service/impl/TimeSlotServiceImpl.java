package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.TimeSlot;
import com.mk.ukim.finki.winterstore.repository.TimeSlotRepository;
import com.mk.ukim.finki.winterstore.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public TimeSlot findByStartTime(LocalDateTime startTime) {
        return timeSlotRepository.findByStartTime(startTime);
    }
}
