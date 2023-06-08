package com.oc01.springbootlibrarymanagementsystem.repository;

import com.oc01.springbootlibrarymanagementsystem.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardRepository extends JpaRepository<Award, Integer> {

    List<Award> findAllByOrderByNameAsc();

}
