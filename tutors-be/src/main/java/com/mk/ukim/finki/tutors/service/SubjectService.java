package com.mk.ukim.finki.tutors.service;

import com.mk.ukim.finki.tutors.model.Subject;
import com.mk.ukim.finki.tutors.model.response.SubjectResponse;

import java.util.List;

public interface SubjectService {
    Subject findBySubjectName(String subjectName);
    List<SubjectResponse> getAllSubjects();
}
