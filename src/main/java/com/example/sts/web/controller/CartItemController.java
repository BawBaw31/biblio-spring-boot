package com.example.sts.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sts.model.Book;
import com.example.sts.model.CartItem;
import com.example.sts.model.User;
import com.example.sts.repository.BookRepository;
import com.example.sts.repository.CartItemRepository;
import com.example.sts.repository.UserRepository;
import com.example.sts.service.CartItemService;
import com.example.sts.web.dto.CartValidationDto;



@Controller
public class CartItemController {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/cart")
    public String cartItems(Model model, Principal principal) {
        User loggedInUser = userRepository.findByEmail(principal.getName());
        List<CartItem> cartItems = cartItemRepository.findAllByUser(loggedInUser);
        model.addAttribute("form", new CartValidationDto(cartItems));
        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String postMethodName(@PathVariable("id") Long id, Principal principal) {
        User loggedInUser = userRepository.findByEmail(principal.getName());
        Book book = bookRepository.findById(id).get();
        CartItem cartItem = new CartItem(loggedInUser, book, 1);
        cartItemRepository.save(cartItem);
        return "redirect:/bookDetails/" + id +"?success";
    }

    @PostMapping("/cart/validate")
    public String postMethodName(@ModelAttribute CartValidationDto form) {
        cartItemService.validateCart(form);
        return "redirect:/cart?success";
    }
}
