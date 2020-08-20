package com.mk.ukim.finki.tutors.service.impl;

import com.mk.ukim.finki.tutors.model.*;
import com.mk.ukim.finki.tutors.model.requests.AddToCartRequest;
import com.mk.ukim.finki.tutors.model.requests.ChargeRequest;
import com.mk.ukim.finki.tutors.model.requests.DeleteFromCartRequest;
import com.mk.ukim.finki.tutors.model.response.CartItemResponse;
import com.mk.ukim.finki.tutors.model.response.StringResponse;
import com.mk.ukim.finki.tutors.repository.*;
import com.mk.ukim.finki.tutors.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import static com.mk.ukim.finki.tutors.service.MappingService.mapCartItemsToCartItemResponse;

@Service
public class CartServiceImpl implements CartService {
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
        timeslot.setAvailable(false);
        timeSlotRepository.save(timeslot);
        Subject subject = subjectRepository.findByName(request.getSubjectName());
        User userFrom = userRepository.findByUsername(request.getUserDetailedFromUsername());
        UserDetailed userDetailedTo = userDetailedRepository.findById(request.getUserDetailedToId());
        CartItem cartItem = new CartItem(userDetailedTo.getUser(), timeslot, subject, userDetailedTo.getPrice());
        UserDetailed userDetailedFrom = userDetailedRepository.findByUser(userFrom);
        userDetailedFrom.addToCart(cartItem);
        userDetailedRepository.save(userDetailedFrom);
        return new StringResponse("Added to cart");
    }

    @Override
    public StringResponse delete(DeleteFromCartRequest request) {
        UserDetailed userDetailed = userDetailedRepository.findByUserUsername(request.getUsername());
        CartItem cartItem = cartItemRepository.findById(request.getCartItem().getId());
        userDetailed.removeFromCart(cartItem);
        userDetailedRepository.save(userDetailed);
        return new StringResponse("Deleted cart item!");
    }

    public List<CartItemResponse> getCartItems(String username){
        UserDetailed userDetailed = userDetailedRepository.findByUserUsername(username);
        return mapCartItemsToCartItemResponse(userDetailed.getCart().getCartItems());
    }

    @Override
    public StringResponse checkout(ChargeRequest chargeRequest) {
        UserDetailed userDetailed = userDetailedRepository.findByUserUsername(chargeRequest.getUsername());
        userDetailed.getCart().setCartItems(new HashSet<>());
        userDetailedRepository.save(userDetailed);
        return new StringResponse("Successfully payed");
    }
}
