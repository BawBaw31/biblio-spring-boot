package com.example.sts.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sts.model.CartItem;
import com.example.sts.model.User;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Collection<CartItem> findAllByUser(User user);
}
