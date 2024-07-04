package com.krtopi.backend.qartel.post;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<PostEntity> getLatestPostsByCity(String city) {
        return this.postRepository.findTop100ByLocationOrderByCreatedAtDesc(city);
    }

    public PostEntity getPostById(String postId) {
        return this.postRepository.findByPostId(postId);
    }

    public List<PostEntity> getPostsByCategoryAndCity(String category, String city) {
        return this.postRepository.findByLocationAndCategory(city, category);
    }


    public List<PostEntity> getPostsByCollege(String college) {
        return this.postRepository.findByCollege(college);
    }

    public PostEntity createPost(PostEntity post) {
        return this.postRepository.save(post);
    }
}
