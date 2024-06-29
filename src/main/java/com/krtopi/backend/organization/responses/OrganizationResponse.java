package com.krtopi.backend.organization.responses;

public class OrganizationResponse {
    public String name;
    public long id;
    public String image;
    private String status;

    public String getName() {
        return name;
    }
    public void setName(String organizationName) {
        this.name = organizationName;
    }

    public long getOrganizationId() {
        return id;
    }

    public void setId(Long organizationId) {
        this.id = organizationId;
    }

    public String getLogo() {
        return image;
    }

    public void setLogo(String organizationLogo) {
        this.image = organizationLogo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}