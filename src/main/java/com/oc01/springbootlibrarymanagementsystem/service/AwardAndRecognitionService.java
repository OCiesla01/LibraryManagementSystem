package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.AwardAndRecognition;

import java.util.List;

public interface AwardAndRecognitionService {

    List<AwardAndRecognition> findAll();
    AwardAndRecognition findById(int id);
    AwardAndRecognition save(AwardAndRecognition awardAndRecognition);
    void deleteById(int id);
}
