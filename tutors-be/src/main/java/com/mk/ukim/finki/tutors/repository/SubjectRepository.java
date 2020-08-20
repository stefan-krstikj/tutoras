package com.mk.ukim.finki.tutors.repository;

import com.mk.ukim.finki.tutors.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByName(String subjectName);
    Subject findById(Integer id);
    List<Subject> findAllByIdIn(List<Integer> ids);
}
