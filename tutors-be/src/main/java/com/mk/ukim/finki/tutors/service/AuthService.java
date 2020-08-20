package com.mk.ukim.finki.tutors.service;


import com.mk.ukim.finki.tutors.model.requests.SignupRequest;
import com.mk.ukim.finki.tutors.model.User;
import com.mk.ukim.finki.tutors.model.response.LoginResponse;
import com.mk.ukim.finki.tutors.model.response.StringResponse;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
    StringResponse signupUser(SignupRequest request) throws Exception;
    LoginResponse loginUser(SignupRequest request) throws Exception;
}
