package com.mk.ukim.finki.tutors.controllers;

import com.mk.ukim.finki.tutors.model.response.SubjectResponse;
import com.mk.ukim.finki.tutors.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/subjects")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectsController {

    private final SubjectService subjectService;

    public SubjectsController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping("/all")
    ResponseEntity<List<SubjectResponse>> getAllSubjects(){
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }
}
