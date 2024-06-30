package com.krtopi.backend.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<PostEntity, String> {
    PostEntity findByPosterId(Long id);
    List<PostEntity> findByTagsContaining(String tag);
    List<PostEntity> findByLocation(String location);
    List<PostEntity> findByDescription(String keyphrase);
    List<PostEntity> findAllByOrderByCreatedAtDesc(Pageable page);
    List<PostEntity> findByLocationOrderByCreatedAtDesc(String location, Pageable pageable);
    List<PostEntity> findByTitleRegex(String keyword);
    List<PostEntity> findByDescriptionRegex(String keyword);
}
