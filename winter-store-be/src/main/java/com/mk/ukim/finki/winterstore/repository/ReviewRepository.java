package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.Review;
import com.mk.ukim.finki.winterstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByFrom(User from);
    List<Review> findAllByTo(User to);
}
