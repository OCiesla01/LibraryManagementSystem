package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.Award;
import com.oc01.springbootlibrarymanagementsystem.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwardServiceImpl implements AwardService {

    private AwardRepository awardRepository;

    @Autowired
    private AwardServiceImpl(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }

    @Override
    public List<Award> findAll() {
        return awardRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Award findById(int id) {
        Optional<Award> result = awardRepository.findById(id);
        Award award;

        if (result.isEmpty()) {
            throw new RuntimeException("Did not find Award with ID: " + id);
        }
        award = result.get();
        return award;
    }

    @Override
    public Award save(Award award) {
        return awardRepository.save(award);
    }

    @Override
    public void deleteById(int id) {
        awardRepository.deleteById(id);
    }
}
