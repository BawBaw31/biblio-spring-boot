package com.example.sts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sts.model.CartItem;
import com.example.sts.model.User;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByUser(User user);
}
