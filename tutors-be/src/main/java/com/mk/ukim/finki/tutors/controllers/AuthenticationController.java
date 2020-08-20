package com.mk.ukim.finki.tutors.controllers;

import com.mk.ukim.finki.tutors.model.requests.SignupRequest;
import com.mk.ukim.finki.tutors.model.response.LoginResponse;
import com.mk.ukim.finki.tutors.model.response.StringResponse;
import com.mk.ukim.finki.tutors.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<StringResponse> signup(@RequestBody SignupRequest request) throws Exception {
        return ResponseEntity.ok(this.authService.signupUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody SignupRequest request) throws Exception{
        logger.info("received login for [{}]", request.getUsername());
        return ResponseEntity.ok(this.authService.loginUser(request));
    }
}
