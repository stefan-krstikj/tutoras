package com.mk.ukim.finki.winterstore.service;


import com.mk.ukim.finki.winterstore.model.UserDetailed;
import com.mk.ukim.finki.winterstore.model.requests.SignupRequest;
import com.mk.ukim.finki.winterstore.model.User;
import com.mk.ukim.finki.winterstore.model.response.LoginResponse;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
    User signupUser(SignupRequest request) throws Exception;
    LoginResponse loginUser(SignupRequest request) throws Exception;
}
