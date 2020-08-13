package com.mk.ukim.finki.winterstore.service;


import com.mk.ukim.finki.winterstore.model.requests.SignupRequest;
import com.mk.ukim.finki.winterstore.model.User;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
    User signupUser(SignupRequest request) throws Exception;
    String loginUser(SignupRequest request) throws Exception;
}
