package com.krtopi.backend.qartel.college;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CollegeRepository extends MongoRepository<CollegeEntity, Long> {
    List<CollegeEntity> findByCollegeCity(String city);
}
