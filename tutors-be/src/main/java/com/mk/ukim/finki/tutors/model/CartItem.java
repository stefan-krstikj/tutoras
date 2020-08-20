package com.mk.ukim.finki.tutors.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userTo;

    @OneToOne
    private TimeSlot userToTimeslot;

    @OneToOne
    private Subject userToSubject;

    private Integer price;

    public CartItem() {
    }

    public CartItem(User userTo, TimeSlot userToTimeslot, Subject userToSubject, Integer price) {
        this.userTo = userTo;
        this.userToTimeslot = userToTimeslot;
        this.userToSubject = userToSubject;
        this.price =  price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
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
