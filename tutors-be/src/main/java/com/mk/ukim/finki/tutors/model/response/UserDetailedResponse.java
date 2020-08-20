package com.mk.ukim.finki.tutors.model.response;

import java.util.List;

public class UserDetailedResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String biography;

    private List<UserTimeslotResponse> freeTimeSlots;

    private List<SubjectResponse> subjects;

    private String role;

    private Integer rating;

    private Integer price;

    public UserDetailedResponse(Integer id, String firstName, String lastName,
                                String phoneNumber, String biography, List<UserTimeslotResponse> freeTimeSlots,
                                List<SubjectResponse> subjects, String role,
                                Integer rating, Integer price) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.biography = biography;
        this.freeTimeSlots = freeTimeSlots;
        this.subjects = subjects;
        this.role = role;
        this.rating = rating;
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public List<UserTimeslotResponse> getFreeTimeSlots() {
        return freeTimeSlots;
    }

    public void setFreeTimeSlots(List<UserTimeslotResponse> freeTimeSlots) {
        this.freeTimeSlots = freeTimeSlots;
    }

    public List<SubjectResponse> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectResponse> subjects) {
        this.subjects = subjects;
    }
}


