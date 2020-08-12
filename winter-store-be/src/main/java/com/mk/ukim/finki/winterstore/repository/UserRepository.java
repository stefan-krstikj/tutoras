package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.Role;
import com.mk.ukim.finki.winterstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
