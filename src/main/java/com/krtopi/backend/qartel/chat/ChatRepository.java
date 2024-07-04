package com.krtopi.backend.qartel.chat;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<ChatEntity, String> {
    List<ChatEntity> findByUserId1OrUserId2(String userId);
    ChatEntity findByConversationId(String id);
}
