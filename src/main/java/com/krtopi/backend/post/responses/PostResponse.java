package com.krtopi.backend.post.responses;

import com.krtopi.backend.post.PostCategory;

import java.util.Date;
import java.util.List;

public class PostResponse {
    private Long id;
    private String posterUsername;
    private String title;
    private String description;
    private List<String> images;
    private float price;
    private String location;
    private PostCategory postType;
    private Date createdAt;
    private Date updatedAt;
}
