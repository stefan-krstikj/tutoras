package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.Subject;
import com.mk.ukim.finki.winterstore.model.response.SubjectResponse;

import java.util.List;

public interface SubjectService {
    Subject findBySubjectName(String subjectName);
    List<SubjectResponse> getAllSubjects();
}
