package com.krtopi.backend.qartel.post;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<PostEntity, String> {
    List<PostEntity> findByLocationAndCategory(String location, String category);
    List<PostEntity> findByCollege(String college);
    PostEntity findByPostId(String id);
    List<PostEntity> findTop100ByLocationOrderByCreatedAtDesc(String location);
}
