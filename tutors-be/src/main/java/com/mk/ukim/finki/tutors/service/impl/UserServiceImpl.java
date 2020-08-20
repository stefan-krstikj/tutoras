package com.mk.ukim.finki.tutors.service.impl;

import com.mk.ukim.finki.tutors.model.User;
import com.mk.ukim.finki.tutors.repository.UserRepository;
import com.mk.ukim.finki.tutors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user){
        // todo check if exits
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
        if(user != null)
            return user;
        else
            throw new UsernameNotFoundException(s);
    }
}
