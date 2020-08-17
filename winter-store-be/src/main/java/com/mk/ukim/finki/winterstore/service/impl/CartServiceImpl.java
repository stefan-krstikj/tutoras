package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.*;
import com.mk.ukim.finki.winterstore.repository.*;
import com.mk.ukim.finki.winterstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserDetailedRepository userDetailedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public CartItem addToCart(Integer timeslotId, Integer subjectId, String userDetailedFromUsername, Integer userDetailedToId){
        TimeSlot timeslot = timeSlotRepository.findById(timeslotId);
        Subject subject = subjectRepository.findById(subjectId);
        User userFrom = userRepository.findByUsername(userDetailedFromUsername);
        User userTo = userDetailedRepository.findById(userDetailedToId).getUser();

        return cartRepository.save(new CartItem(userFrom, userTo, timeslot, subject));
    }
}
