package com.mk.ukim.finki.tutors.validators;

import com.mk.ukim.finki.tutors.model.requests.SignupRequest;
import com.mk.ukim.finki.tutors.repository.UserRepository;

public class UserValidator {

    public static void validateSignUpRequest(SignupRequest signUpRequest, UserRepository userRepository) throws Exception {
        if(signUpRequest.getUsername() == null || signUpRequest.getUsername().length() <=5)
            throw new Exception("Email is too short");

        if(signUpRequest.getPassword() == null || signUpRequest.getPassword().length() < 6)
            throw new Exception("Password is too short");

        if(!signUpRequest.getUsername().contains("@"))
            throw new Exception("Invalid email!");

        if(userRepository.existsByUsername(signUpRequest.getUsername()))
            throw new Exception("User exists!");

    }
}
