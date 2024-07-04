package com.krtopi.backend.qartel.college;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "colleges")
public class CollegeEntity {
    @Id
    private String collegeId;
    private String collegeName;
    private String collegeCity;
    private String collegeState;
}
