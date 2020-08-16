package com.mk.ukim.finki.winterstore.model.requests;

import com.mk.ukim.finki.winterstore.model.response.TimeslotResponse;

public class UpdateUserTimeSlotsRequest {
    private String username;
    private Integer id;
    private TimeslotResponse timeslot;

    public UpdateUserTimeSlotsRequest(String username, Integer id, TimeslotResponse timeslot) {
        this.username = username;
        this.id = id;
        this.timeslot = timeslot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TimeslotResponse getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeslotResponse timeslot) {
        this.timeslot = timeslot;
    }
}
