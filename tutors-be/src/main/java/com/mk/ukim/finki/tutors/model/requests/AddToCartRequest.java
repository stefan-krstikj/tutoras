package com.mk.ukim.finki.tutors.model.requests;

public class AddToCartRequest {
    private Integer timeslotId;
    private String subjectName;
    private String userDetailedFromUsername;
    private Integer userDetailedToId;

    public AddToCartRequest(Integer timeslotId, String subjectName, String userDetailedFromUsername, Integer userDetailedToId) {
        this.timeslotId = timeslotId;
        this.subjectName = subjectName;
        this.userDetailedFromUsername = userDetailedFromUsername;
        this.userDetailedToId = userDetailedToId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(Integer timeslotId) {
        this.timeslotId = timeslotId;
    }

    public String getUserDetailedFromUsername() {
        return userDetailedFromUsername;
    }

    public void setUserDetailedFromUsername(String userDetailedFromUsername) {
        this.userDetailedFromUsername = userDetailedFromUsername;
    }

    public Integer getUserDetailedToId() {
        return userDetailedToId;
    }

    public void setUserDetailedToId(Integer userDetailedToId) {
        this.userDetailedToId = userDetailedToId;
    }
}
