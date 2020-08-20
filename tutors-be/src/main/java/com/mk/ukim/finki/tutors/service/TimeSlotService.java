package com.mk.ukim.finki.tutors.service;

import com.mk.ukim.finki.tutors.model.TimeSlot;
import com.mk.ukim.finki.tutors.model.response.UserTimeslotResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeSlotService {
    TimeSlot findByStartTime(LocalDateTime startTime);
    List<UserTimeslotResponse> findTimeslotsForUsername(String username);
}
