package com.example.sts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sts.model.Book;
import com.example.sts.model.CartItem;
import com.example.sts.repository.CartItemRepository;
import com.example.sts.web.dto.CartValidationDto;

@Service
public class CartItemServiceImpl implements CartItemService {
    
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public void validateCart(CartValidationDto cartValidationDto) {
        for (CartItem cartItem : cartValidationDto.getCartItems()) {
            Book book = cartItem.getBook();
            if (book.getQuantity() >= cartItem.getQuantity()) {
                book.setQuantity(book.getQuantity() - cartItem.getQuantity());
                cartItemRepository.save(cartItem);
                cartItemRepository.delete(cartItem);
            } else {
                throw new IllegalArgumentException("Not enough books in stock");
            }
        }
    }
}
