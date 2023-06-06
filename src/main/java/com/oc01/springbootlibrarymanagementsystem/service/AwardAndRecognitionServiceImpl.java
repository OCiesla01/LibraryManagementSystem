package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.AwardAndRecognition;
import com.oc01.springbootlibrarymanagementsystem.repository.AwardAndRecognitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwardAndRecognitionServiceImpl implements AwardAndRecognitionService {

    @Autowired
    private AwardAndRecognitionRepository awardAndRecognitionRepository;
    @Override
    public List<AwardAndRecognition> findAll() {
        return awardAndRecognitionRepository.findAll();
    }

    @Override
    public AwardAndRecognition findById(int id) {
        Optional<AwardAndRecognition> result = awardAndRecognitionRepository.findById(id);
        AwardAndRecognition awardAndRecognition;

        if (result.isEmpty()) {
            throw new RuntimeException("Did not find Award or Recognition with ID: " + id);
        }
        awardAndRecognition = result.get();
        return awardAndRecognition;
    }

    @Override
    public AwardAndRecognition save(AwardAndRecognition awardAndRecognition) {
        return awardAndRecognitionRepository.save(awardAndRecognition);
    }

    @Override
    public void deleteById(int id) {
        awardAndRecognitionRepository.deleteById(id);
    }
}
