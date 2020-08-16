package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserDetailedRepository extends JpaRepository<UserDetailed, Long> {
    List<UserDetailed> findAllByFirstNameContaining(String firstName);
    List<UserDetailed> findAllByLastNameContaining(String lastName);
    UserDetailed findByUser(User user);


    UserDetailed findByUserUsername(String username);
    List<UserDetailed> findAllBySubjectsContaining(Subject subject);
    List<UserDetailed> findAllByTimeSlots(TimeSlot timeSlot);
    UserDetailed findById(Integer id);


    @Transactional
    @Modifying
    @Query("update UserDetailed ud set ud.firstName = :firstName, ud.lastName=:lastName, ud.phoneNumber = :phoneNumber" +
            ", ud.biography=:bio, ud.price=:price where ud.id = :id")
    int updateUserDetails(Integer id, String firstName, String lastName, String phoneNumber, String bio, Integer price);

    @Transactional
    @Modifying
    @Query("update UserDetailed ud set ud.subjects = :subjects where ud.id = :id")
    int updateUserSubjects(Integer id, @Param("subjects") Set<Subject> subjects);
}
