package com.mk.ukim.finki.winterstore.service;


import com.mk.ukim.finki.winterstore.model.SignUpRequest;
import com.mk.ukim.finki.winterstore.model.User;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
    User signUpUser(SignUpRequest request) throws Exception;
}
