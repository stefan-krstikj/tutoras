package com.mk.ukim.finki.tutors.model.requests;

public class UpdateUserDetailsRequest {
    private String firstName;
    private String lastName;
    private String biography;
    private String phoneNumber;
    private Integer id;
    private Integer price;
    private String role;

    public UpdateUserDetailsRequest(String firstName, String lastName, String biography,
                                    String phoneNumber, Integer id, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
