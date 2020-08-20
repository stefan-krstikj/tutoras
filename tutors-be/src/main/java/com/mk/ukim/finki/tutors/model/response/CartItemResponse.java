package com.mk.ukim.finki.tutors.model.response;

public class CartItemResponse {
    private Integer id;
    private String userTo;
    private Integer price;
    private SubjectResponse subject;

    public CartItemResponse(Integer id, String userTo, Integer price, SubjectResponse subject) {
        this.id = id;
        this.userTo = userTo;
        this.price = price;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public SubjectResponse getSubject() {
        return subject;
    }

    public void setSubject(SubjectResponse subject) {
        this.subject = subject;
    }
}
