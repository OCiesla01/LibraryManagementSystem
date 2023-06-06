package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();
    Author findById(int id);
    Author save(Author author);
    void deleteById(int id);
}
