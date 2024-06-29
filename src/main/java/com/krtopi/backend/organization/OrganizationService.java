package com.krtopi.backend.organization;

public interface OrganizationService {
    public String createOrganization(OrganizationEntity org);
    public String updateOrganization(OrganizationEntity org);
    public String deleteOrganization(Long id);
    public OrganizationEntity getOrganization(Long organizationId);
    OrganizationEntity findByOrgName(long id);
}
