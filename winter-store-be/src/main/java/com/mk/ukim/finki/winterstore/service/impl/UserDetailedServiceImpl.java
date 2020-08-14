package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.*;
import com.mk.ukim.finki.winterstore.repository.RoleRepository;
import com.mk.ukim.finki.winterstore.repository.SubjectRepository;
import com.mk.ukim.finki.winterstore.repository.UserDetailedRepository;
import com.mk.ukim.finki.winterstore.repository.UserRepository;
import com.mk.ukim.finki.winterstore.service.UserDetailedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<UserDetailed> findAllBySubject(String subject){
        Subject subjectObject = subjectRepository.findByName(subject);
        return userDetailedRepository.findAllBySubjectsContaining(subjectObject);
    }

    @Override
    public List<UserDetailed> findAllByFirstNameAndLastName(String name){
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
    public List<UserDetailed> findAllBySubjectsContainingAndRole(String subject, String role) {
        List<UserDetailed> usersWithRole = findAllByRole(role);
        List<UserDetailed> usersWithSubject = findAllBySubject(subject);
        return usersWithRole.stream()
                .filter(usersWithSubject::contains)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailed> findAllByTimeSlot(TimeSlot timeSlot) {
        return this.userDetailedRepository.findAllByFreeTimeSlots(timeSlot);
    }

    @Override
    public List<UserDetailed> findAllByRole(String role) {
        Role roleObject = roleRepository.findByName(role);
        List<User> usersWithRole = userRepository.findAllByRolesContaining(roleObject);
        List<UserDetailed> userDetailsWithRole = new ArrayList<>();
        for(User u : usersWithRole)
            userDetailsWithRole.add(userDetailedRepository.findByUser(u));
        return userDetailsWithRole;
    }

    @Override
    public UserDetailed findById(Integer id) {
        return userDetailedRepository.findById(id);
    }


}
