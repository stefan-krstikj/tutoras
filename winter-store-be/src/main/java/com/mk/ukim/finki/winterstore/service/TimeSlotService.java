package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.TimeSlot;
import com.mk.ukim.finki.winterstore.model.response.TimeslotResponse;
import com.mk.ukim.finki.winterstore.model.response.UserTimeslotResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeSlotService {
    TimeSlot findByStartTime(LocalDateTime startTime);
    List<UserTimeslotResponse> findTimeslotsForUsername(String username);
}
