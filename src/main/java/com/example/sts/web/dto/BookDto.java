package com.example.sts.web.dto;

import com.example.sts.model.Book;

import lombok.Data;

@Data
public class BookDto {
    private String name;
    private String author;
    private String cover;
    private String categorie;
    private Integer quantity;

    public BookDto() {

    }

    public BookDto(Book book) {
        super();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.cover = book.getCover();
        this.quantity = book.getQuantity();
        this.categorie = book.getCategorie();
    }
}
