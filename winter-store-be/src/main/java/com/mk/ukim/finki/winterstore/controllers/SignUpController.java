package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/login")
public class SignUpController {

    private final AuthService authService;

    public SignUpController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String username,
                         @RequestParam String password) throws Exception {
        this.authService.signUpUser(username,password);
        return "Successfull signup";
    }
}
