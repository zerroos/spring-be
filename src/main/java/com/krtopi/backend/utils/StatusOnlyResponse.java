package com.krtopi.backend.utils;

public class StatusOnlyResponse {
    private String status;
    public StatusOnlyResponse(){

    }
    public StatusOnlyResponse(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
