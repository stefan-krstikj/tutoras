package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.Role;
import com.mk.ukim.finki.winterstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    List<User> findAllByRole(Role role);

    @Transactional
    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    int changePasswordForUserWithId( Integer id, String password);
}
