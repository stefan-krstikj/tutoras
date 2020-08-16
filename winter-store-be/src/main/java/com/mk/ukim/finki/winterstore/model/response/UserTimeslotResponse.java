package com.mk.ukim.finki.winterstore.model.response;

public class UserTimeslotResponse {
    private Integer id;
    private TimeslotResponse startTime;
    private TimeslotResponse endTime;

    public UserTimeslotResponse(Integer id, TimeslotResponse startTime, TimeslotResponse endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TimeslotResponse getStartTime() {
        return startTime;
    }

    public void setStartTime(TimeslotResponse startTime) {
        this.startTime = startTime;
    }

    public TimeslotResponse getEndTime() {
        return endTime;
    }

    public void setEndTime(TimeslotResponse endTime) {
        this.endTime = endTime;
    }
}
