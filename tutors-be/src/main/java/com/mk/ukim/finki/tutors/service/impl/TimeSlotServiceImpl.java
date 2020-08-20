package com.mk.ukim.finki.tutors.service.impl;

import com.mk.ukim.finki.tutors.model.TimeSlot;
import com.mk.ukim.finki.tutors.model.UserDetailed;
import com.mk.ukim.finki.tutors.model.response.UserTimeslotResponse;
import com.mk.ukim.finki.tutors.repository.TimeSlotRepository;
import com.mk.ukim.finki.tutors.repository.UserDetailedRepository;
import com.mk.ukim.finki.tutors.service.MappingService;
import com.mk.ukim.finki.tutors.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<TimeSlot> timeslots = userDetailed.getTimeSlots()
                .stream()
                .filter(TimeSlot::getAvailable)
                .collect(Collectors.toSet());
        return MappingService.mapTimeSlotToTimeSlotResposne(timeslots);
    }

}
