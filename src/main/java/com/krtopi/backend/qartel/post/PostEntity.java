package com.krtopi.backend.qartel.post;

import jakarta.persistence.Id;
import jakarta.persistence.Version;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "posts")
public class PostEntity {
    @Id
    private String postId;
    private String title;
    private String description;
    private String[] images;
    private float price;
    private String location;
    private String college;
    private String category;
    private String userId;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @Version
    private Long version;
}
