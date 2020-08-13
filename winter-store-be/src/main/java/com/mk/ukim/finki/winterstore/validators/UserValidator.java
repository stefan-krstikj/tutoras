package com.mk.ukim.finki.winterstore.validators;

import com.mk.ukim.finki.winterstore.model.requests.SignupRequest;
import com.mk.ukim.finki.winterstore.repository.UserRepository;

public class UserValidator {

    public static void validateSignUpRequest(SignupRequest signUpRequest, UserRepository userRepository) throws Exception {
//        if(!signUpRequest.getUsername().contains("@"))
//            throw new Exception("Invalid email!");

        if(userRepository.existsByUsername(signUpRequest.getUsername()))
            throw new Exception("Username exists!");

    }
}
