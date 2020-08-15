package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.TimeSlot;
import com.mk.ukim.finki.winterstore.model.UserDetailed;
import com.mk.ukim.finki.winterstore.model.requests.ChangePasswordRequest;
import com.mk.ukim.finki.winterstore.model.requests.UpdateUserDetailsRequest;
import com.mk.ukim.finki.winterstore.model.requests.UpdateUserSubjectsRequest;
import com.mk.ukim.finki.winterstore.model.response.UserDetailsResponse;

import java.util.List;
import java.util.Optional;

public interface UserDetailedService {
    UserDetailed saveUserDetails(UserDetailed userDetails);
    Optional<UserDetailed> getUserDetails(UserDetailed userDetails);
    List<UserDetailed> findAllByFirstName(String firstName);
    List<UserDetailed> findAllByLastName(String lastName);
    List<UserDetailed> findAllBySubjectsContainingAndRole(String subject, String role);
    List<UserDetailed> findAllByTimeSlot(TimeSlot timeSlot);
    List<UserDetailed> findAllByRole(String role);
    List<UserDetailed> findAllBySubject(String subject);
    List<UserDetailed> findAllByNameContainingAndRole(String name, String role);
    List<UserDetailed> findAllByFirstNameAndLastName(String name);
    UserDetailed findById(Integer id);
    UserDetailsResponse findByUsername(String username);
    String changePassword(ChangePasswordRequest changePasswordRequest);
    String updateUserInformation(UpdateUserDetailsRequest updateUserDetailsRequest);
    String updateUserSubjects(UpdateUserSubjectsRequest updateUserSubjectsRequest);
}
