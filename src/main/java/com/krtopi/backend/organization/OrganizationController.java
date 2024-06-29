package com.krtopi.backend.organization;

import com.krtopi.backend.authentication.LoginResponse;
import com.krtopi.backend.organization.responses.OrganizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/organization")
public class OrganizationController {

    OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<OrganizationResponse> getOrganization(@PathVariable("id") long id) {
        OrganizationEntity ans =  organizationService.findByOrgName(id);
        OrganizationResponse orgResp = new OrganizationResponse();
        System.out.println(ans);
        if(ans == null) {
            return ResponseEntity.ok(orgResp);
        }
        orgResp.setName(ans.getName());
        orgResp.setLogo(ans.getImage());
        orgResp.setId(ans.getId());
        orgResp.setStatus("Success");
        return ResponseEntity.ok(orgResp);
    }
    @PostMapping(path = "/create")
    public String  createOrganization(@RequestBody OrganizationEntity organization) {
        return this.organizationService.createOrganization(organization);
    }
    @DeleteMapping(path = "/{id}")
    public String  deleteOrganization(@PathVariable("id") long id) {
        return this.organizationService.deleteOrganization(id);
    }
}
