package com.mk.ukim.finki.tutors.repository;

import com.mk.ukim.finki.tutors.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
