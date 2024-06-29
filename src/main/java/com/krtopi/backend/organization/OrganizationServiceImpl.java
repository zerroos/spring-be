package com.krtopi.backend.organization;

import com.krtopi.backend.exceptions.ItemNotFound;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository org){
        this.organizationRepository = org;
    }
    @Override
    public String createOrganization(OrganizationEntity org){
        this.organizationRepository.save(org);
        return "Success";
    }
    public String updateOrganization(OrganizationEntity org){
        this.organizationRepository.save(org);
        return "Success";
    }

    public String deleteOrganization(Long id){
        this.organizationRepository.deleteById(id);
        return "Success";
    }
    public OrganizationEntity getOrganization(Long id){
        if(this.organizationRepository.findById(id).isEmpty())
            throw new ItemNotFound(id);
        return this.organizationRepository.findById(id).get();
    }
    public OrganizationEntity findByOrgName(long id){
        return this.organizationRepository.findById(id);
    }
}
