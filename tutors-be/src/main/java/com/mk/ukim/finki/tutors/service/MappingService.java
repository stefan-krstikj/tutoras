package com.mk.ukim.finki.tutors.service;

import com.mk.ukim.finki.tutors.model.*;
import com.mk.ukim.finki.tutors.model.response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MappingService {
    public static List<UserTimeslotResponse> mapTimeSlotToTimeSlotResposne(Set<TimeSlot> timeSlots) {
        List<UserTimeslotResponse> list = new ArrayList<>();
        for (TimeSlot s : timeSlots) {
            // we are not returning unavailable timeslots!
            if(!s.getAvailable())
                continue;
            TimeslotResponse startTime = new TimeslotResponse(s.getStartTime().getYear(),
                    s.getStartTime().getMonthValue(),
                    s.getStartTime().getDayOfMonth(),
                    s.getStartTime().getHour(),
                    s.getStartTime().getMinute());
            TimeslotResponse endTime = new TimeslotResponse(s.getEndTime().getYear(),
                    s.getEndTime().getMonthValue(),
                    s.getEndTime().getDayOfMonth(),
                    s.getEndTime().getHour(),
                    s.getEndTime().getMinute());
            list.add(new UserTimeslotResponse(s.getId(), startTime, endTime));
        }
            return list;
    }

    public static List<SubjectResponse> mapSubjectsToSubjectResponse(Set<Subject> subjects) {
        List<SubjectResponse> list = new ArrayList<>();
        for (Subject s : subjects)
            list.add(mapSubjectToSubjectResponse(s));
        return list;
    }

    public static SubjectResponse mapSubjectToSubjectResponse(Subject subjects) {
        return new SubjectResponse(subjects.getId(), subjects.getName());
    }



    public static UserDetailedResponse mapUserDetailedToUserDetailedResponse(UserDetailed userDetailed){
        return new UserDetailedResponse(
                userDetailed.getId(), userDetailed.getFirstName(),
                userDetailed.getLastName(), userDetailed.getPhoneNumber(),
                userDetailed.getBiography(),
                mapTimeSlotToTimeSlotResposne(userDetailed.getTimeSlots()),
                mapSubjectsToSubjectResponse(userDetailed.getSubjects()),
                userDetailed.getUser().getRole().getName(), userDetailed.getRating(), userDetailed.getPrice());
    }

    public static List<CartItemResponse> mapCartItemsToCartItemResponse(Set<CartItem> cartItems){
        return cartItems.stream().map(MappingService::mapCartItemToCartItemResponse).collect(Collectors.toList());
    }

    public static CartItemResponse mapCartItemToCartItemResponse(CartItem cartItem){
        return new CartItemResponse(cartItem.getId(), cartItem.getUserTo().getUsername(),
                cartItem.getPrice(), mapSubjectToSubjectResponse(cartItem.getUserToSubject()));
    }
}
