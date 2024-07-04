package com.krtopi.backend.qartel.chat;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "chats")
public class ChatEntity {
    @Id
    private String messageId;
    private String senderId;
    private String messageText;
    private Date timestamp;
}
