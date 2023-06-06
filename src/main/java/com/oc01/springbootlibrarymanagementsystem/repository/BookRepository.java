package com.oc01.springbootlibrarymanagementsystem.repository;

import com.oc01.springbootlibrarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByOrderByTitleAsc();
    List<Book> findByTitle(String title);
}
