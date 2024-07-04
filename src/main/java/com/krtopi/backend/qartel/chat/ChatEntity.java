package com.krtopi.backend.qartel.chat;

import jakarta.persistence.Id;
import jakarta.persistence.Version;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "chats")
public class ChatEntity {
    @Id
    private String conversationId;
    private MessageEntity[] messages;
    private String userId1;
    private String userId2;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @Version
    private Long version;
}
