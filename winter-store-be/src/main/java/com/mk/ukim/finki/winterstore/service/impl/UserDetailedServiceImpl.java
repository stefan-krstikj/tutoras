package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.*;
import com.mk.ukim.finki.winterstore.model.requests.ChangePasswordRequest;
import com.mk.ukim.finki.winterstore.model.requests.UpdateUserDetailsRequest;
import com.mk.ukim.finki.winterstore.model.requests.UpdateUserSubjectsRequest;
import com.mk.ukim.finki.winterstore.model.requests.UpdateUserTimeSlotsRequest;
import com.mk.ukim.finki.winterstore.model.response.SubjectResponse;
import com.mk.ukim.finki.winterstore.model.response.UserDetailsResponse;
import com.mk.ukim.finki.winterstore.repository.RoleRepository;
import com.mk.ukim.finki.winterstore.repository.SubjectRepository;
import com.mk.ukim.finki.winterstore.repository.UserDetailedRepository;
import com.mk.ukim.finki.winterstore.repository.UserRepository;
import com.mk.ukim.finki.winterstore.service.UserDetailedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.mk.ukim.finki.winterstore.service.MappingService.*;

@Service
public class UserDetailedServiceImpl implements UserDetailedService {

    @Autowired
    UserDetailedRepository userDetailedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetailed saveUserDetails(UserDetailed userDetails) {
        return this.userDetailedRepository.save(userDetails);
    }

    @Override
    public Optional<UserDetailed> getUserDetails(UserDetailed userDetails) {
        return userDetailedRepository.findById(userDetails.getId().longValue());
    }

    @Override
    public List<UserDetailed> findAllByFirstName(String firstName) {
        return userDetailedRepository.findAllByFirstNameContaining(firstName);
    }

    @Override
    public List<UserDetailed> findAllByLastName(String lastName) {
        return userDetailedRepository.findAllByLastNameContaining(lastName);
    }

    @Override
    public List<UserDetailed> findAllBySubject(String subject) {
        Subject subjectObject = subjectRepository.findByName(subject);
        return userDetailedRepository.findAllBySubjectsContaining(subjectObject);
    }

    @Override
    public List<UserDetailed> findAllByFirstNameAndLastName(String name) {
        List<UserDetailed> userDetailsContainingFirstName = findAllByFirstName(name);
        List<UserDetailed> userDetailsContainingLastName = findAllByLastName(name);
        return userDetailsContainingFirstName
                .stream()
                .filter(userDetailsContainingLastName::contains)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailed> findAllByNameContainingAndRole(String name, String role) {
        List<UserDetailed> userDetailsContainingName = findAllByFirstNameAndLastName(name);
        List<UserDetailed> userDetailsWithRole = findAllByRole(role);
        return userDetailsWithRole
                .stream()
                .filter(userDetailsContainingName::contains)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailsResponse> findAllBySubjectsContainingAndRole(Integer subjectId, String role) {
        List<UserDetailed> usersWithRole = findAllByRole(role);
        Subject subject = subjectRepository.findById(subjectId);
        List<UserDetailed> usersWithSubject = findAllBySubject(subject.getName());
        Role roleObj = roleRepository.findByName(role);
        return usersWithRole.stream()
                .filter(o -> usersWithSubject.contains(o))
                .map(o -> mapUserDetailedToUserDetailedResponse(o,roleObj))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailed> findAllByTimeSlot(TimeSlot timeSlot) {
        return this.userDetailedRepository.findAllByTimeSlots(timeSlot);
    }

    @Override
    public List<UserDetailed> findAllByRole(String role) {
        Role roleObject = roleRepository.findByName(role);
        List<User> usersWithRole = userRepository.findAllByRole(roleObject);
        List<UserDetailed> userDetailsWithRole = new ArrayList<>();
        for (User u : usersWithRole)
            userDetailsWithRole.add(userDetailedRepository.findByUser(u));
        return userDetailsWithRole;
    }

    @Override
    public UserDetailed findById(Integer id) {
        return userDetailedRepository.findById(id);
    }

    @Override
    public UserDetailsResponse findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserDetailed userDetailed = userDetailedRepository.findByUser(user);
        Role role = user.getRole();
        return mapUserDetailedToUserDetailedResponse(userDetailed, role);
    }

    // todo chagnge implementation, this is obviously bad security
    @Override
    public String changePassword(ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findByUsername(changePasswordRequest.getUsername());
        userRepository.changePasswordForUserWithId(user.getId(),
                this.passwordEncoder.encode(changePasswordRequest.getPassword()));
        return "Password changed";
    }

    @Override
    public String updateUserInformation(UpdateUserDetailsRequest updateUserDetailsRequest) {
        userDetailedRepository.updateUserDetails(
                updateUserDetailsRequest.getId(),
                updateUserDetailsRequest.getFirstName(),
                updateUserDetailsRequest.getLastName(),
                updateUserDetailsRequest.getPhoneNumber(),
                updateUserDetailsRequest.getBiography());
        return "User successfully updated";
    }

    @Override
    public String updateUserSubjects(UpdateUserSubjectsRequest updateUserSubjectsRequest) {
        UserDetailed userDetailed = userDetailedRepository.findByUserUsername(updateUserSubjectsRequest.getUsername());
        Set<Subject> newSubjects = new HashSet<>(subjectRepository.findAllByIdIn(
                updateUserSubjectsRequest.getSubjects()
                        .stream()
                        .map(SubjectResponse::getId)
                        .collect(Collectors.toList())));
        userDetailed.setSubjects(newSubjects);
        userDetailedRepository.save(userDetailed);
        return "Subjects updated!";
    }

    @Override
    public String removeUserTimeSlot(UpdateUserTimeSlotsRequest updateUserTimeSlotsRequest) {
        UserDetailed userDetailed = userDetailedRepository.findByUserUsername(updateUserTimeSlotsRequest.getUsername());
        userDetailed.setTimeSlots(userDetailed.getTimeSlots()
                .stream()
                .filter(it -> !it.getId().equals(updateUserTimeSlotsRequest.getId()))
                .collect(Collectors.toSet()));
        userDetailedRepository.save(userDetailed);
        return "Removed timeslot";
    }

    @Override
    public String addUserTimeSlot(UpdateUserTimeSlotsRequest request) {
        UserDetailed userDetailed = userDetailedRepository.findByUserUsername(request.getUsername());

        LocalDateTime startTime = LocalDateTime.of(
                LocalDate.of(
                        request.getTimeslot().getYear(),
                        request.getTimeslot().getMonth(),
                        request.getTimeslot().getDay()),
                LocalTime.of(
                        request.getTimeslot().getHour(),
                        request.getTimeslot().getMinute()
                ));
        LocalDateTime endTime = startTime.plusHours(1);

        userDetailed.addTimeSlot(new TimeSlot(startTime, endTime));
        userDetailedRepository.save(userDetailed);

        return "Added new timeslot";
    }
}
