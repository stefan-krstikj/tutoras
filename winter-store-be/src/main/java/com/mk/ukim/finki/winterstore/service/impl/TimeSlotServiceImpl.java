package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.TimeSlot;
import com.mk.ukim.finki.winterstore.model.UserDetailed;
import com.mk.ukim.finki.winterstore.model.response.UserTimeslotResponse;
import com.mk.ukim.finki.winterstore.repository.TimeSlotRepository;
import com.mk.ukim.finki.winterstore.repository.UserDetailedRepository;
import com.mk.ukim.finki.winterstore.service.MappingService;
import com.mk.ukim.finki.winterstore.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private UserDetailedRepository userDetailedRepository;


    @Override
    public TimeSlot findByStartTime(LocalDateTime startTime) {
        return timeSlotRepository.findByStartTime(startTime);
    }

    @Override
    public List<UserTimeslotResponse> findTimeslotsForUsername(String username) {
        UserDetailed userDetailed = userDetailedRepository.findByUserUsername(username);
        Set<TimeSlot> timeslots = userDetailed.getTimeSlots();
        return MappingService.mapTimeSlotToTimeSlotResposne(timeslots);
    }

}
