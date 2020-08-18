package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.model.requests.AddToCartRequest;
import com.mk.ukim.finki.winterstore.model.response.StringResponse;
import com.mk.ukim.finki.winterstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @PostMapping("/add")
    public ResponseEntity<StringResponse> login(@RequestBody AddToCartRequest request) throws Exception{
        return ResponseEntity.ok(this.cartItemService.addToCart(request));
    }
}
