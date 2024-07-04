package com.krtopi.backend.qartel.business;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {
    private BusinessRepository businessRepository;

    public BusinessService(BusinessRepository businessRepository){
        this.businessRepository = businessRepository;
    }

    public List<BusinessEntity> getStoresByCity(String city){
        return this.businessRepository.findByStoreLocation(city);
    }
    public BusinessEntity getStoreById(String id){
    return this.businessRepository.findByStoreId(id);
    }
}
