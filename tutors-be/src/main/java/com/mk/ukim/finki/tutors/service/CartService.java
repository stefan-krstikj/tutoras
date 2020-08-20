package com.mk.ukim.finki.tutors.service;

import com.mk.ukim.finki.tutors.model.requests.AddToCartRequest;
import com.mk.ukim.finki.tutors.model.requests.ChargeRequest;
import com.mk.ukim.finki.tutors.model.requests.DeleteFromCartRequest;
import com.mk.ukim.finki.tutors.model.response.CartItemResponse;
import com.mk.ukim.finki.tutors.model.response.StringResponse;

import java.util.List;

public interface CartService {
    StringResponse addToCart(AddToCartRequest request);

    StringResponse delete(DeleteFromCartRequest request);
    List<CartItemResponse> getCartItems(String username);
    StringResponse checkout(ChargeRequest chargeRequest);
}
