package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailedRepository extends JpaRepository<UserDetailed, Long> {
    List<UserDetailed> findAllByFirstNameContaining(String firstName);
    List<UserDetailed> findAllByLastNameContaining(String lastName);
    UserDetailed findByUser(User user);
    UserDetailed findByUserUsername(String username);
    List<UserDetailed> findAllBySubjectsContaining(Subject subject);
    List<UserDetailed> findAllByFreeTimeSlots(TimeSlot timeSlot);

    UserDetailed findById(Integer id);
}
