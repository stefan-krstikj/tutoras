package com.mk.ukim.finki.winterstore.repository;

import com.mk.ukim.finki.winterstore.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findById(Integer id);
}
