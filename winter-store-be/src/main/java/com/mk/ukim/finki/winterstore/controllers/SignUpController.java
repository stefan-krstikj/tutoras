package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin
@RequestMapping("/api/login")
public class SignUpController {
    Logger logger = LoggerFactory.getLogger(SignUpController.class);

    private final AuthService authService;

    public SignUpController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String name,
                         @RequestParam String username,
                         @RequestParam String password) throws Exception {
        logger.info("Received signup for: " + username + " " + password);
//        this.authService.signUpUser(username,password);
        return "Successfull signup";
    }
}
