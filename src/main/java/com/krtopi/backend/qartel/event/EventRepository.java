package com.krtopi.backend.qartel.event;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<EventEntity, String> {
    List<EventEntity> findByLocation(String city);
    EventEntity findByEventId(String id);
}
