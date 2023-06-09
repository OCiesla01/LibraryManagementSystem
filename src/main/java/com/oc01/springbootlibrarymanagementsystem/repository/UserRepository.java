package com.oc01.springbootlibrarymanagementsystem.repository;

import com.oc01.springbootlibrarymanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByOrderByLastNameAsc();

    @Query("SELECT u FROM User u JOIN u.role r WHERE r.name = :roleName")
    List<User> findUsersByRole(@Param("roleName") String roleName);
}
