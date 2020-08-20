package com.mk.ukim.finki.tutors.service.impl;

import com.mk.ukim.finki.tutors.model.Subject;
import com.mk.ukim.finki.tutors.model.response.SubjectResponse;
import com.mk.ukim.finki.tutors.repository.SubjectRepository;
import com.mk.ukim.finki.tutors.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject findBySubjectName(String subjectName) {
        return subjectRepository.findByName(subjectName);
    }

    @Override
    public List<SubjectResponse> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(it -> new SubjectResponse(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }
}
