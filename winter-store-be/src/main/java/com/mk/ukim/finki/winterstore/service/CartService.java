package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.CartItem;

public interface CartService {
    CartItem addToCart(Integer timeslotId, Integer subjectId, String userDetailedFromUsername, Integer userDetailedToId);
}
