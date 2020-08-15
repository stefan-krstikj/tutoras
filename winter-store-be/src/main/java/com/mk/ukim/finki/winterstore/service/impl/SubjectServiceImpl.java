package com.mk.ukim.finki.winterstore.service.impl;

import com.mk.ukim.finki.winterstore.model.Subject;
import com.mk.ukim.finki.winterstore.model.response.SubjectResponse;
import com.mk.ukim.finki.winterstore.repository.SubjectRepository;
import com.mk.ukim.finki.winterstore.service.SubjectService;
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
