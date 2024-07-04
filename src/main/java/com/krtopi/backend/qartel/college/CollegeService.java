package com.krtopi.backend.qartel.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public CollegeService(CollegeRepository collegeRepository){
        this.collegeRepository = collegeRepository;
    }

    public List<CollegeEntity> getCollegesByCity(String city){
        return this.collegeRepository.findByCollegeCity(city);
    }
}
