package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.model.SignUpRequest;
import com.mk.ukim.finki.winterstore.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class SignUpController {
    Logger logger = LoggerFactory.getLogger(SignUpController.class);

    private final AuthService authService;

    public SignUpController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequest request) throws Exception {
        this.authService.signUpUser(request);
        return "Successfull signup";
    }
}
