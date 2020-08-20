package com.mk.ukim.finki.tutors.repository;

import com.mk.ukim.finki.tutors.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findById(Integer id);
}
