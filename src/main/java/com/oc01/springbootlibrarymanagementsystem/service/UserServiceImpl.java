package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.User;
import com.oc01.springbootlibrarymanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User user;

        if (result.isEmpty()) {
            throw new RuntimeException("Did not find User with ID: " + id);
        }
        user = result.get();
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByRole(String roleName) {
        return userRepository.findUsersByRole(roleName);
    }
}
