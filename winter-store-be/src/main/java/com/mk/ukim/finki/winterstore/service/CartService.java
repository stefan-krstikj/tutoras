package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.CartItem;
import com.mk.ukim.finki.winterstore.model.requests.AddToCartRequest;
import com.mk.ukim.finki.winterstore.model.requests.ChargeRequest;
import com.mk.ukim.finki.winterstore.model.requests.DeleteFromCartRequest;
import com.mk.ukim.finki.winterstore.model.response.CartItemResponse;
import com.mk.ukim.finki.winterstore.model.response.StringResponse;

import java.util.List;

public interface CartService {
    StringResponse addToCart(AddToCartRequest request);

    StringResponse delete(DeleteFromCartRequest request);
    List<CartItemResponse> getCartItems(String username);
    StringResponse checkout(ChargeRequest chargeRequest);
}
