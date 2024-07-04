package com.krtopi.backend.qartel.user;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String profileImage;
    private String password;
}
