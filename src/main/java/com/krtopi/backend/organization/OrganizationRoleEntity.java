package com.krtopi.backend.organization;
import jakarta.persistence.*;

@Table(name = "roles")
@Entity
public class OrganizationRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name="organization_role_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity parentOrganization;

    @Column(nullable = false, name="role_name")
    private String roleName;

    @Column(nullable = false, name="role_weight")
    private int roleWeight;

}
