package com.krtopi.backend.organization;

import com.krtopi.backend.user.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "organization")
@Entity
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name="organization_id")
    private Long id;

    @Column(unique = true, length  = 100, nullable = false, name="name")
    private String name;

    @Column(length  = 100, nullable = false, name="img_url")
    private String image;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "membership",
            joinColumns = { @JoinColumn(name = "organization_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<UserEntity> members = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;

    @OneToMany(mappedBy = "parentOrganization")
    private Set<OrganizationRoleEntity> organizationRoles = new HashSet<>();

    @Column(length  = 100, name="parent_organization")
    private String parentEntity;

    @CreationTimestamp
    @Column(nullable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public OrganizationEntity(){

    }
    public OrganizationEntity(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEntity> getMembers() {
        return members;
    }

    public void setMembers(Set<UserEntity> members) {
        this.members = members;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public Set<OrganizationRoleEntity> getOrganizationRoles() {
        return organizationRoles;
    }

    public void setOrganizationRoles(Set<OrganizationRoleEntity> organizationRoles) {
        this.organizationRoles = organizationRoles;
    }

    public String getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(String parentEntity) {
        this.parentEntity = parentEntity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
