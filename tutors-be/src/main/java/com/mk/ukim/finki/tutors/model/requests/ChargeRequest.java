package com.mk.ukim.finki.tutors.model.requests;

public class ChargeRequest {
    private String username;
    private Integer amount;
    private StripeToken token;

    public ChargeRequest(String username, Integer amount, StripeToken token) {
        this.username = username;
        this.amount = amount;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public StripeToken getToken() {
        return token;
    }

    public void setToken(StripeToken token) {
        this.token = token;
    }
}
