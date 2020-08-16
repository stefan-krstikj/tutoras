package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.TimeSlot;
import com.mk.ukim.finki.winterstore.model.response.TimeslotResponse;
import com.mk.ukim.finki.winterstore.model.response.UserTimeslotResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MappingService {
    public static List<UserTimeslotResponse> mapTimeSlotToTimeSlotResposne(Set<TimeSlot> timeSlots) {
        List<UserTimeslotResponse> list = new ArrayList<>();
        for (TimeSlot s : timeSlots) {
            TimeslotResponse startTime = new TimeslotResponse(s.getStartTime().getYear(),
                    s.getStartTime().getMonthValue(),
                    s.getStartTime().getDayOfMonth(),
                    s.getStartTime().getHour(),
                    s.getStartTime().getMinute());
            TimeslotResponse endTime = new TimeslotResponse(s.getEndTime().getYear(),
                    s.getEndTime().getMonthValue(),
                    s.getEndTime().getDayOfMonth(),
                    s.getEndTime().getHour(),
                    s.getEndTime().getMinute());
            list.add(new UserTimeslotResponse(s.getId(), startTime, endTime));
        }
            return list;
    }
}
