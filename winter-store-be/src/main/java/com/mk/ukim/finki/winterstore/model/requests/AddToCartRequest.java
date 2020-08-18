package com.mk.ukim.finki.winterstore.model.requests;

public class AddToCartRequest {
    private Integer timeslotId;
    private Integer subjectId;
    private String userDetailedFromUsername;
    private Integer userDetailedToId;

    public AddToCartRequest(Integer timeslotId, Integer subjectId, String userDetailedFromUsername, Integer userDetailedToId) {
        this.timeslotId = timeslotId;
        this.subjectId = subjectId;
        this.userDetailedFromUsername = userDetailedFromUsername;
        this.userDetailedToId = userDetailedToId;
    }

    public Integer getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(Integer timeslotId) {
        this.timeslotId = timeslotId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
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
