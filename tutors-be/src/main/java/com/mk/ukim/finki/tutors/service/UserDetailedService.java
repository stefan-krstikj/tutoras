package com.mk.ukim.finki.tutors.service;

import com.mk.ukim.finki.tutors.model.TimeSlot;
import com.mk.ukim.finki.tutors.model.UserDetailed;
import com.mk.ukim.finki.tutors.model.requests.ChangePasswordRequest;
import com.mk.ukim.finki.tutors.model.requests.UpdateUserDetailsRequest;
import com.mk.ukim.finki.tutors.model.requests.UpdateUserSubjectsRequest;
import com.mk.ukim.finki.tutors.model.requests.UpdateUserTimeSlotsRequest;
import com.mk.ukim.finki.tutors.model.response.UserDetailedResponse;

import java.util.List;
import java.util.Optional;

public interface UserDetailedService {
    UserDetailed saveUserDetails(UserDetailed userDetails);
    Optional<UserDetailed> getUserDetails(UserDetailed userDetails);
    List<UserDetailed> findAllByFirstName(String firstName);
    List<UserDetailed> findAllByLastName(String lastName);
    List<UserDetailedResponse> findAllBySubjectsContainingAndRole(Integer subjectId, String role);
    List<UserDetailed> findAllByTimeSlot(TimeSlot timeSlot);
    List<UserDetailed> findAllByRole(String role);
    List<UserDetailed> findAllBySubject(String subject);
    List<UserDetailed> findAllByNameContainingAndRole(String name, String role);
    List<UserDetailed> findAllByFirstNameAndLastName(String name);
    UserDetailedResponse findById(Integer id);
    UserDetailedResponse findByUsername(String username);
    String changePassword(ChangePasswordRequest changePasswordRequest);
    String updateUserInformation(UpdateUserDetailsRequest updateUserDetailsRequest);
    String updateUserSubjects(UpdateUserSubjectsRequest updateUserSubjectsRequest);
    String removeUserTimeSlot(UpdateUserTimeSlotsRequest updateUserTimeSlotsRequest);
    String addUserTimeSlot(UpdateUserTimeSlotsRequest updateUserTimeSlotsRequest);
}
