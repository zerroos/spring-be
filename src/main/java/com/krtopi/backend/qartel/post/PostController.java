package com.krtopi.backend.qartel.post;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }
    // GET /api/posts/latest?city={userCity}
    @GetMapping("/api/posts/latest")
    public List<PostEntity> getLatestPostsByCity(@RequestParam String city) {
        return postService.getLatestPostsByCity(city);
    }

    // GET /api/posts/{postId}
    @GetMapping("/api/posts/{postId}")
    public PostEntity getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    // GET /api/posts?category={selectedCategory}&city={userCity}
    @GetMapping(value="/api/posts", params = {"category", "city"})
    public List<PostEntity> getPostsByCategoryAndCity(@RequestParam String category, @RequestParam String city) {
        return postService.getPostsByCategoryAndCity(category, city);
    }

    // GET /api/posts?college={selectedCollege}
    @GetMapping(value="/api/posts", params="college")
    public List<PostEntity> getPostsByCollege(@RequestParam String college) {
        return postService.getPostsByCollege(college);
    }

    // POST /api/posts
    @PostMapping("/api/posts")
    public PostEntity createPost(@RequestBody PostEntity post) {
        return postService.createPost(post);
    }
}
