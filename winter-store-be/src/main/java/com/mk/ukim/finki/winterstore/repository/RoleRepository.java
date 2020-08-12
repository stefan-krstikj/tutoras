package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.Role;
import com.mk.ukim.finki.winterstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
