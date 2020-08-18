package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.model.requests.AddToCartRequest;
import com.mk.ukim.finki.winterstore.model.requests.DeleteFromCartRequest;
import com.mk.ukim.finki.winterstore.model.response.CartItemResponse;
import com.mk.ukim.finki.winterstore.model.response.StringResponse;
import com.mk.ukim.finki.winterstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<StringResponse> add(@RequestBody AddToCartRequest request) throws Exception{
        return ResponseEntity.ok(this.cartService.addToCart(request));
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<CartItemResponse>> getCart(@PathVariable String username) {
        return ResponseEntity.ok(this.cartService.getCartItems(username));
    }

    @PostMapping("/delete")
    public ResponseEntity<StringResponse> delete(@RequestBody DeleteFromCartRequest deleteFromCartRequest){
        return ResponseEntity.ok(this.cartService.delete(deleteFromCartRequest));
    }
}
