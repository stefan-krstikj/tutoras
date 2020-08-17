package com.mk.ukim.finki.winterstore.model;

public class CartItem {
    private Integer id;
    private User userFrom;
    private User userTo;
    private TimeSlot userToTimeslot;
    private Subject userToSubject;

    public CartItem(User userFrom, User userTo, TimeSlot userToTimeslot, Subject userToSubject) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.userToTimeslot = userToTimeslot;
        this.userToSubject = userToSubject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public TimeSlot getUserToTimeslot() {
        return userToTimeslot;
    }

    public void setUserToTimeslot(TimeSlot userToTimeslot) {
        this.userToTimeslot = userToTimeslot;
    }

    public Subject getUserToSubject() {
        return userToSubject;
    }

    public void setUserToSubject(Subject userToSubject) {
        this.userToSubject = userToSubject;
    }
}
