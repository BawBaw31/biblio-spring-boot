package com.example.sts.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    private String cover;
    
    private String categorie;

    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private Collection < CartItem > cartItems;

    public Book() {

    }

    public Book(String name, String author, String cover, Integer quantity, String categorie) {
        super();
        this.name = name;
        this.author = author;
        this.cover = cover;
        this.quantity = quantity;
        this.categorie = categorie;
    }
}
