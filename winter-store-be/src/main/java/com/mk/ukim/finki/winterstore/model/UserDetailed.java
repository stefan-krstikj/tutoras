package com.mk.ukim.finki.winterstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_details")
public class UserDetailed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "biography")
    private String biography;

    @Column(name = "time_slots")
    @ManyToMany
    private List<TimeSlot> freeTimeSlots;

    @Column(name = "subjects")
    @ManyToMany
    private List<TimeSlot> subjects;

    public UserDetailed() {
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

    public List<TimeSlot> getFreeTimeSlots() {
        return freeTimeSlots;
    }

    public void setFreeTimeSlots(List<TimeSlot> freeTimeSlots) {
        this.freeTimeSlots = freeTimeSlots;
    }

    public List<TimeSlot> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<TimeSlot> subjects) {
        this.subjects = subjects;
    }
}
