package com.mk.ukim.finki.tutors.model.requests;

import com.mk.ukim.finki.tutors.model.response.CartItemResponse;

public class DeleteFromCartRequest {
    private String username;
    private CartItemResponse cartItem;

    public DeleteFromCartRequest(String username, CartItemResponse cartItem) {
        this.username = username;
        this.cartItem = cartItem;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CartItemResponse getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItemResponse cartItem) {
        this.cartItem = cartItem;
    }
}
