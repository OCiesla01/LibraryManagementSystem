package com.oc01.springbootlibrarymanagementsystem.repository;

import com.oc01.springbootlibrarymanagementsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
