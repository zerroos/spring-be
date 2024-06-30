package com.krtopi.backend.post;

import com.krtopi.backend.post.responses.ListPostResponse;
import com.krtopi.backend.post.responses.PostResponse;
import com.krtopi.backend.utils.StatusOnlyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }
    @GetMapping(path="/posts/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("id") long id) {
        PostResponse postResp = new PostResponse();
        return ResponseEntity.ok(postResp);
    }
    @GetMapping(path="/posts/all")
    public ResponseEntity<ListPostResponse> getAllPosts() {
        List<PostEntity> posts = this.postService.getAllPosts();
        return ResponseEntity.ok(new ListPostResponse(posts));
    }
    @PostMapping(path="/post")
    public ResponseEntity<StatusOnlyResponse> createPost(@RequestBody PostEntity post) {
        try {
            this.postService.savePost(post);
            return new ResponseEntity<>(new StatusOnlyResponse("Success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(path="/post", params="postId")
    public ResponseEntity<StatusOnlyResponse> deletePost(@RequestParam(name = "postId") String postId) {
        try {
            this.postService.deletePost(postId);
            return new ResponseEntity<>(new StatusOnlyResponse("Success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/posts", params="tag")
    public ResponseEntity<List<PostEntity>> getPostByTag(@RequestParam(name = "tag") String tag) {
        try {
            List<PostEntity> posts = postService.getByTag(tag);
            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/posts", params="location")
    public ResponseEntity<List<PostEntity>> getPostByLocation(@RequestParam(name = "location") String location) {
        try {
            List<PostEntity> posts = postService.getByLocation(location);
            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/posts")
    public ResponseEntity<List<PostEntity>> getMostRecentPost() {
        try {
            List<PostEntity> posts = postService.getMostRecent();
            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/posts/recent", params = {"location", "count"})
    public ResponseEntity<List<PostEntity>> getMostRecentPostByLocationLimit(@RequestParam(name = "location") String location, @RequestParam(name = "count") int count) {
        try {
            List<PostEntity> posts = postService.getMostRecentAtLocation(location, count);
            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/posts", params = "title")
    public ResponseEntity<List<PostEntity>> getMostRecentPostByTitleRegex(@RequestParam(name = "title") String title) {
        try {
            List<PostEntity> posts = postService.getByTitle(title);
            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/posts", params = "desc")
    public ResponseEntity<List<PostEntity>> getMostRecentPostByDescriptionRegex(@RequestParam(name = "desc") String keyword) {
        try {
            List<PostEntity> posts = postService.getByDescription(keyword);
            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
