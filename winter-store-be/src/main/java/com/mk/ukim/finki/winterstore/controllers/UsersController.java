package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.model.UserDetailed;
import com.mk.ukim.finki.winterstore.service.UserDetailedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
    Logger logger = LoggerFactory.getLogger(UsersController.class);

    private final UserDetailedService userDetailedService;

    public UsersController(UserDetailedService userDetailedService) {
        this.userDetailedService = userDetailedService;
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDetailed> findById(@RequestParam Integer id){
        return ResponseEntity.ok(userDetailedService.findById(id));
    }

    @GetMapping("/tutors")
    ResponseEntity<List<UserDetailed>> findAllTutors(){
        return ResponseEntity.ok(userDetailedService.findAllByRole("tutor"));
    }

    @GetMapping("/students")
    ResponseEntity<List<UserDetailed>> findAllStudents(){
        return ResponseEntity.ok(userDetailedService.findAllByRole("student"));
    }

    @GetMapping("/tutors/subject/{subject}")
    ResponseEntity<List<UserDetailed>> findAllTutorsBySubject(@RequestParam String subject){
        return ResponseEntity.ok(userDetailedService.findAllBySubjectsContainingAndRole(subject, "tutor"));
    }

    @GetMapping("/students/subject/{subject}")
    ResponseEntity<List<UserDetailed>> findAllStudentsBySubject(@RequestParam String subject){
        return ResponseEntity.ok(userDetailedService.findAllBySubjectsContainingAndRole(subject, "student"));
    }

    @GetMapping("/tutors/name/{name}")
    ResponseEntity<List<UserDetailed>> findAllTutorsByName(@RequestParam String name){
        return ResponseEntity.ok(userDetailedService.findAllByNameContainingAndRole(name, "tutor"));
    }

    @GetMapping("/students/name/{name}")
    ResponseEntity<List<UserDetailed>> findAllStudentsByName(@RequestParam String name){
        return ResponseEntity.ok(userDetailedService.findAllByNameContainingAndRole(name, "student"));
    }
}
