package com.mk.ukim.finki.tutors.service;

import com.mk.ukim.finki.tutors.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User registerUser(User user);
}
