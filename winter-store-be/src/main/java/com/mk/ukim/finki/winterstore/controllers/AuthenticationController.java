package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.model.requests.SignupRequest;
import com.mk.ukim.finki.winterstore.model.response.TokenResponse;
import com.mk.ukim.finki.winterstore.service.AuthService;
import net.minidev.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final AuthService authService;

    public AuthenticationController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) throws Exception {
        this.authService.signupUser(request);
        return ResponseEntity.ok( "Successfull signup");
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody SignupRequest request) throws Exception{
        logger.info("received login for [{}]", request.getUsername());
        String token = this.authService.loginUser(request);
        logger.info(", responding with token [{}]", token);
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
