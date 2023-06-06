package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findById(int id);
    Book save(Book book);
    void deleteById(int id);
}
