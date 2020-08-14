package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByName(String subjectName);

}
