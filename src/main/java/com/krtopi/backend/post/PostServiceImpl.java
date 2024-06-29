package com.krtopi.backend.post;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public void savePost(PostEntity post) {
        this.postRepository.save(post);
    }
    public List<PostEntity> getAllPosts(){
        return this.postRepository.findAll();
    }

    @Override
    public List<PostEntity> getByTag(String tag) {
        return this.postRepository.findByTagsContaining(tag);
    }

    @Override
    public List<PostEntity> getByLocation(String location) {
        return this.postRepository.findByLocation(location);
    }
    public List<PostEntity> getMostRecent() {
        Pageable pageable = PageRequest.of(0, 10); // Limit to 10 documents
        return postRepository.findAllByOrderByCreatedAtDesc(pageable);
    }
    public List<PostEntity> getMostRecentAtLocation(String location, int count) {
        Pageable pageable = PageRequest.of(0, count); // Limit to 10 documents
        return postRepository.findByLocationOrderByCreatedAtDesc(location, pageable);
    }
    public List<PostEntity> getByTitle(String title){
        return postRepository.findByTitleRegex(title);
    }
    public List<PostEntity> getByDescription(String description){
        return postRepository.findByDescriptionRegex(description);
    }
}
