package com.krtopi.backend.post;

import com.krtopi.backend.user.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Document(collection = "posts")
public class PostEntity {

    @Id
    private String id;
    private Long posterId;
    private String title;
    private String description;
    private List<String> images;
    private List<String> tags;
    private float price;
    private String location;
    private PostCategory postType;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @Version
    private Long version;

    public PostEntity(){

    }

    public PostEntity(Long posterId, String title, String description, List<String> images, List<String> tags, float price, String location, PostCategory postType){
        this.posterId = posterId;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.images = images;
        this.price = price;
        this.location = location;
        this.postType = postType;
    }

    public PostEntity(Long posterId, String title, String description, List<String> images, PostCategory postType){
        this.posterId = posterId;
        this.title = title;
        this.description = description;
        this.images = images;
        this.postType = postType;
    }

    public PostEntity(Long posterId, String title, String description, List<String> images, List<String> tags, String location, PostCategory postType){
        this.posterId = posterId;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.images = images;
        this.location = location;
        this.postType = postType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPosterId() {
        return posterId;
    }

    public void setPosterId(Long posterId) {
        this.posterId = posterId;
    }

    public String getTitle(){ return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PostCategory getPostType() {
        return postType;
    }

    public void setPostType(PostCategory postType) {
        this.postType = postType;
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
}
