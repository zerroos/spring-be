package com.krtopi.backend.post;

import java.util.List;

public interface PostService {
    void savePost(PostEntity post);
    List<PostEntity> getAllPosts();
    List<PostEntity> getByTag(String tag);
    List<PostEntity> getByLocation(String location);
    List<PostEntity> getMostRecent();
    List<PostEntity> getMostRecentAtLocation(String location, int count);
    List<PostEntity> getByTitle(String title);
    List<PostEntity> getByDescription(String title);
}
