package com.krtopi.backend.qartel.business;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BusinessRepository extends MongoRepository<BusinessEntity, Long> {

    List<BusinessEntity> findByStoreLocation(String city);
    BusinessEntity findByStoreId(String id);
}
