package com.krtopi.backend.qartel.business;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business")
public class BusinessEntity {
    @Id
    private String storeId;
    private String storeName;
    private String storeOwner;
    private String storeImage;
    private String storeCategory;
    private String storeLocation;
    private String storeDescription;
}
