package com.example.sts.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sts.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
    Collection<Book> findAllByCategorie(String categorie);
}
