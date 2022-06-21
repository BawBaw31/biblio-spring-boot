package com.example.sts.service;

import com.example.sts.web.dto.CartValidationDto;

public interface CartItemService {
    void validateCart(CartValidationDto cartValidationDto);
}
