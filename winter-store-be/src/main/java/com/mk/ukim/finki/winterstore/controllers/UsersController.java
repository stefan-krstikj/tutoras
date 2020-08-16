package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.model.UserDetailed;
import com.mk.ukim.finki.winterstore.model.requests.ChangePasswordRequest;
import com.mk.ukim.finki.winterstore.model.requests.UpdateUserDetailsRequest;
import com.mk.ukim.finki.winterstore.model.requests.UpdateUserSubjectsRequest;
import com.mk.ukim.finki.winterstore.model.requests.UpdateUserTimeSlotsRequest;
import com.mk.ukim.finki.winterstore.model.response.StringResponse;
import com.mk.ukim.finki.winterstore.model.response.UserDetailedResponse;
import com.mk.ukim.finki.winterstore.service.UserDetailedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{username}")
    ResponseEntity<UserDetailedResponse> findById(@PathVariable String username){
        UserDetailedResponse response = userDetailedService.findByUsername(username);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/tutors")
    ResponseEntity<List<UserDetailed>> findAllTutors(){
        return ResponseEntity.ok(userDetailedService.findAllByRole("tutor"));
    }

    @GetMapping("/students")
    ResponseEntity<List<UserDetailed>> findAllStudents(){
        return ResponseEntity.ok(userDetailedService.findAllByRole("student"));
    }

    @GetMapping("/tutors/subject/{subjectId}")
    ResponseEntity<List<UserDetailedResponse>> findAllTutorsBySubject(@PathVariable Integer subjectId){
        List<UserDetailedResponse> response = userDetailedService.findAllBySubjectsContainingAndRole(subjectId, "tutor");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/students/subject/{subjectId}")
    ResponseEntity<List<UserDetailedResponse>> findAllStudentsBySubject(@PathVariable Integer subjectId){
        return ResponseEntity.ok(userDetailedService.findAllBySubjectsContainingAndRole(subjectId, "student"));
    }

    @GetMapping("/tutors/name/{name}")
    ResponseEntity<List<UserDetailed>> findAllTutorsByName(@RequestParam String name){
        return ResponseEntity.ok(userDetailedService.findAllByNameContainingAndRole(name, "tutor"));
    }

    @GetMapping("/students/name/{name}")
    ResponseEntity<List<UserDetailed>> findAllStudentsByName(@RequestParam String name){
        return ResponseEntity.ok(userDetailedService.findAllByNameContainingAndRole(name, "student"));
    }

    @PostMapping("/change-password")
    ResponseEntity<StringResponse> changePassowrd(@RequestBody ChangePasswordRequest changePasswordRequest){
        return ResponseEntity.ok(new StringResponse(userDetailedService.changePassword(changePasswordRequest)));
    }

    @PostMapping("/update-details")
    ResponseEntity<StringResponse> updateUserInformation(@RequestBody UpdateUserDetailsRequest updateUserDetailsRequest){
        return ResponseEntity.ok(new StringResponse(userDetailedService.updateUserInformation(updateUserDetailsRequest)));
    }

    @PostMapping("/update-subjects")
    ResponseEntity<StringResponse> updateUserSubjects(@RequestBody UpdateUserSubjectsRequest updateUserSubjectsRequest){
        return ResponseEntity.ok(new StringResponse(userDetailedService.updateUserSubjects(updateUserSubjectsRequest)));
    }

    @PostMapping("/add-timeslot")
    ResponseEntity<StringResponse> addUserTimeslot(@RequestBody UpdateUserTimeSlotsRequest updateUserTimeSlotsRequest){
        return ResponseEntity.ok(new StringResponse(userDetailedService.addUserTimeSlot(updateUserTimeSlotsRequest)));
    }

    @PostMapping("/delete-timeslot")
    ResponseEntity<StringResponse> deleteUserTimeslot(@RequestBody UpdateUserTimeSlotsRequest updateUserTimeSlotsRequest){
        return ResponseEntity.ok(new StringResponse(userDetailedService.removeUserTimeSlot(updateUserTimeSlotsRequest)));
    }
}
