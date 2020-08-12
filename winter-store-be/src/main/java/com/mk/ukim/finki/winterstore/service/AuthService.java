package com.mk.ukim.finki.winterstore.service;


import com.mk.ukim.finki.winterstore.model.User;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
    User signUpUser(String username, String password) throws Exception;
}
