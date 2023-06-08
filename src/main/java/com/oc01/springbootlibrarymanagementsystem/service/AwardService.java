package com.oc01.springbootlibrarymanagementsystem.service;

import com.oc01.springbootlibrarymanagementsystem.entity.Award;

import java.util.List;

public interface AwardService {

    List<Award> findAll();
    Award findById(int id);
    Award save(Award award);
    void deleteById(int id);
}
