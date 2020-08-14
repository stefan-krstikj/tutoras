package com.mk.ukim.finki.winterstore.service;

import com.mk.ukim.finki.winterstore.model.Subject;

public interface SubjectService {
    Subject findBySubjectName(String subjectName);
}
