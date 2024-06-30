package com.krtopi.backend.events;

import com.krtopi.backend.post.PostEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<EventEntity, String> {
    List<EventEntity> findByPosterId(Long id);
    List<EventEntity> findByTagsContaining(String tag);
    List<EventEntity> findByLocation(String location);
    List<EventEntity> findByDescription(String keyphrase);
    List<EventEntity> findAllByOrderByCreatedAtDesc(Pageable page);
    List<EventEntity> findByLocationOrderByCreatedAtDesc(String location, Pageable pageable);
    List<EventEntity> findByTitleRegex(String keyword);
    List<EventEntity> findByDescriptionRegex(String keyword);
}
