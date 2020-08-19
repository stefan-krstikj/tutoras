package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.model.requests.ChargeRequest;
import com.mk.ukim.finki.winterstore.model.response.StringResponse;
import com.mk.ukim.finki.winterstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:4200")
public class CheckoutController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Autowired
    private CartService cartService;

    @PostMapping("/charge")
    public ResponseEntity<StringResponse> checkout(@RequestBody ChargeRequest chargeRequest) {
        return ResponseEntity.ok(this.cartService.checkout(chargeRequest));

//        try {
//            ShoppingCart shoppingCart = this.shoppingCartService.checkoutShoppingCart(this.authService.getCurrentUserId(), chargeRequest);
//            return "redirect:/products?message=Successful Payment";
//        } catch (RuntimeException ex) {
//            return "redirect:/payments/charge?error=" + ex.getLocalizedMessage();
//        }
    }

}
