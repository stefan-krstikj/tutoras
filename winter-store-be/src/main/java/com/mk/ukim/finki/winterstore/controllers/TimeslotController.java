package com.mk.ukim.finki.winterstore.controllers;

import com.mk.ukim.finki.winterstore.model.response.TimeslotResponse;
import com.mk.ukim.finki.winterstore.model.response.UserTimeslotResponse;
import com.mk.ukim.finki.winterstore.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/timeslots")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeslotController {

    @Autowired
    TimeSlotService timeSlotService;

    @GetMapping("/{username}")
    ResponseEntity<List<UserTimeslotResponse>> findById(@PathVariable String username){
        List<UserTimeslotResponse> response = this.timeSlotService.findTimeslotsForUsername(username);
        return ResponseEntity.ok(response);
    }
}
