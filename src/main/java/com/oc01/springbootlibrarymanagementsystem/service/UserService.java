package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(int id);
    User save(User user);
    void deleteById(int id);
}
