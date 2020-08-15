package com.mk.ukim.finki.winterstore.model.requests;

import com.mk.ukim.finki.winterstore.model.TimeSlot;

import java.util.List;

public class UpdateUserTimeSlotsRequest {
    private String username;
    private TimeSlotRequest timeSlot;

    public UpdateUserTimeSlotsRequest(String username, TimeSlotRequest timeSlot) {
        this.username = username;
        this.timeSlot = timeSlot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TimeSlotRequest getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlotRequest timeSlot) {
        this.timeSlot = timeSlot;
    }
}
