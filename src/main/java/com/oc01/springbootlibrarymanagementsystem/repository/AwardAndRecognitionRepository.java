package com.oc01.springbootlibrarymanagementsystem.repository;

import com.oc01.springbootlibrarymanagementsystem.entity.AwardAndRecognition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardAndRecognitionRepository extends JpaRepository<AwardAndRecognition, Integer> {

    List<AwardAndRecognition> findAllByOrderByNameAsc();

}
