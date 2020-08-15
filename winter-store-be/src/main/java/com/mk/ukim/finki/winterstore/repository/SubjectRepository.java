package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByName(String subjectName);
    List<Subject> findAllByIdIn(List<Integer> ids);
}
