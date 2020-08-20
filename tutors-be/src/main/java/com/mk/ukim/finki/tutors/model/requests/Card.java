package com.mk.ukim.finki.tutors.model.requests;

public class Card {

    private String address_city;

    private String address_country;

    private String address_line1;

    private String address_state;

    private Integer address_zip;

    private String brand;

    private String country;

    private Integer exp_month;

    private Integer exp_year;

    private String funding;

    private String id;

    private Integer last4;

    private String name;

    private String object;

    public Card(String address_city, String address_country, String address_line1, String address_state, Integer address_zip, String brand, String country, Integer exp_month, Integer exp_year, String funding, String id, Integer last4, String name, String object) {
        this.address_city = address_city;
        this.address_country = address_country;
        this.address_line1 = address_line1;
        this.address_state = address_state;
        this.address_zip = address_zip;
        this.brand = brand;
        this.country = country;
        this.exp_month = exp_month;
        this.exp_year = exp_year;
        this.funding = funding;
        this.id = id;
        this.last4 = last4;
        this.name = name;
        this.object = object;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_country() {
        return address_country;
    }

    public void setAddress_country(String address_country) {
        this.address_country = address_country;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public Integer getAddress_zip() {
        return address_zip;
    }

    public void setAddress_zip(Integer address_zip) {
        this.address_zip = address_zip;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getExp_month() {
        return exp_month;
    }

    public void setExp_month(Integer exp_month) {
        this.exp_month = exp_month;
    }

    public Integer getExp_year() {
        return exp_year;
    }

    public void setExp_year(Integer exp_year) {
        this.exp_year = exp_year;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLast4() {
        return last4;
    }

    public void setLast4(Integer last4) {
        this.last4 = last4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
