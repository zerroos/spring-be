package com.krtopi.backend.authentication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends CrudRepository<AuthUserEntity, Long> {

    Optional<AuthUserEntity> findByEmail(String email);
}
