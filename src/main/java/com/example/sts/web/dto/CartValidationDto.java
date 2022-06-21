package com.example.sts.web.dto;

import java.util.List;

import com.example.sts.model.CartItem;

import lombok.Data;

@Data
public class CartValidationDto {
    private List<CartItem> cartItems;

    public CartValidationDto() {

    }

    public CartValidationDto(List<CartItem> cartItems) {
        super();
        this.cartItems = cartItems;
    }

    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }
}
