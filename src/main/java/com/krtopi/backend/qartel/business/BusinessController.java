package com.krtopi.backend.qartel.business;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusinessController {

    private BusinessService storeService;

    public BusinessController(BusinessService storeService){
        this.storeService = storeService;
    }
    @GetMapping("/api/stores")
    public List<BusinessEntity> getStoresByCity(@RequestParam String city) {
        return storeService.getStoresByCity(city);
    }

    // GET /api/stores/{storeId}
    @GetMapping("/api/stores/{storeId}")
    public BusinessEntity getStoreById(@PathVariable String storeId) {
        return storeService.getStoreById(storeId);
    }
}
