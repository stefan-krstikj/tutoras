package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.*;
import com.mk.ukim.finki.winterstore.model.requests.AddToCartRequest;
import com.mk.ukim.finki.winterstore.model.requests.DeleteFromCartRequest;
import com.mk.ukim.finki.winterstore.model.response.CartItemResponse;
import com.mk.ukim.finki.winterstore.model.response.StringResponse;
import com.mk.ukim.finki.winterstore.repository.*;
import com.mk.ukim.finki.winterstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mk.ukim.finki.winterstore.service.MappingService.mapCartItemToCartItemResponse;
import static com.mk.ukim.finki.winterstore.service.MappingService.mapCartItemsToCartItemResponse;

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
}
