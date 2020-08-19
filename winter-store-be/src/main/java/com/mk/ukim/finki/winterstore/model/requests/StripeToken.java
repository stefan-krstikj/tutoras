package com.mk.ukim.finki.winterstore.model.requests;

public class StripeToken {
    private Card card;
    private String id;
    private String client_ip;
    private Integer created;
    private String token;
    private String type;

    public StripeToken(Card card, String id, String client_ip, Integer created, String token, String type) {
        this.card = card;
        this.id = id;
        this.client_ip = client_ip;
        this.created = created;
        this.token = token;
        this.type = type;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
