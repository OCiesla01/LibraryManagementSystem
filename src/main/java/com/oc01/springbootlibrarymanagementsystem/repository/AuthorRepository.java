package com.oc01.springbootlibrarymanagementsystem.repository;

import com.oc01.springbootlibrarymanagementsystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAllByOrderByLastNameAsc();
    List<Author> findByLastName(String lastName);
}
