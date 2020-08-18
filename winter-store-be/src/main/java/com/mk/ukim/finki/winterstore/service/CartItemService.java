package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.CartItem;
import com.mk.ukim.finki.winterstore.model.requests.AddToCartRequest;
import com.mk.ukim.finki.winterstore.model.response.StringResponse;

public interface CartItemService {
    StringResponse addToCart(AddToCartRequest request);
}
