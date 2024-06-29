package com.krtopi.backend.post.responses;

import com.krtopi.backend.post.PostEntity;

import java.util.List;

public class ListPostResponse {
    List<PostEntity> posts;
    public ListPostResponse(){

    }
    public ListPostResponse(List<PostEntity> posts){
        this.posts = posts;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }
}
