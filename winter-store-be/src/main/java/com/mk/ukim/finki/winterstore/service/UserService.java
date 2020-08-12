package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User registerUser(User user);
}
