package com.mk.ukim.finki.winterstore.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mk.ukim.finki.winterstore.model.Subject;
import com.mk.ukim.finki.winterstore.model.TimeSlot;
import com.mk.ukim.finki.winterstore.model.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class UserDetailsResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String biography;

    private List<TimeSlotResponse> freeTimeSlots;

    private List<SubjectResponse> subjects;

    private String role;

    public UserDetailsResponse(Integer id, String firstName, String lastName, String phoneNumber, String biography, List<TimeSlotResponse> freeTimeSlots, List<SubjectResponse> subjects, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.biography = biography;
        this.freeTimeSlots = freeTimeSlots;
        this.subjects = subjects;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<TimeSlotResponse> getFreeTimeSlots() {
        return freeTimeSlots;
    }

    public void setFreeTimeSlots(List<TimeSlotResponse> freeTimeSlots) {
        this.freeTimeSlots = freeTimeSlots;
    }

    public List<SubjectResponse> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectResponse> subjects) {
        this.subjects = subjects;
    }
}


