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

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeCity() {
        return collegeCity;
    }

    public void setCollegeCity(String collegeCity) {
        this.collegeCity = collegeCity;
    }

    public String getCollegeState() {
        return collegeState;
    }

    public void setCollegeState(String collegeState) {
        this.collegeState = collegeState;
    }
}
