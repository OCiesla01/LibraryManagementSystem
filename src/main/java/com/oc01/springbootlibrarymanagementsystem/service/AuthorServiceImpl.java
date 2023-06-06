package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.Author;
import com.oc01.springbootlibrarymanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> findAll() {
        return authorRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Author findById(int id) {
        Optional<Author> result = authorRepository.findById(id);
        Author author;

        if (result.isEmpty()) {
            throw new RuntimeException("Did not find Author with ID: " + id);
        }
        author = result.get();
        return author;
    }

    public List<Author> findByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}
