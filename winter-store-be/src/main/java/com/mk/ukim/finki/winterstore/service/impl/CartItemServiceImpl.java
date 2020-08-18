package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.*;
import com.mk.ukim.finki.winterstore.model.requests.AddToCartRequest;
import com.mk.ukim.finki.winterstore.model.response.StringResponse;
import com.mk.ukim.finki.winterstore.repository.*;
import com.mk.ukim.finki.winterstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    UserDetailedRepository userDetailedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public StringResponse addToCart(AddToCartRequest request){
        TimeSlot timeslot = timeSlotRepository.findById(request.getTimeslotId());
        Subject subject = subjectRepository.findById(request.getSubjectId());
        User userFrom = userRepository.findByUsername(request.getUserDetailedFromUsername());
        UserDetailed userDetailedTo = userDetailedRepository.findById(request.getUserDetailedToId());
        User userTo = userDetailedTo.getUser();
        CartItem cartItem = new CartItem(userTo, timeslot, subject, userDetailedTo.getPrice());
//        cartItemRepository.save(cartItem);
        userDetailedTo.getCart().addItemToCart(cartItem);
        userDetailedRepository.save(userDetailedTo);
        return new StringResponse("Added to cart");
    }
}
