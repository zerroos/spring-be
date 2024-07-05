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

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public MessageEntity[] getMessages() {
        return messages;
    }

    public void setMessages(MessageEntity[] messages) {
        this.messages = messages;
    }

    public String getUserId1() {
        return userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }

    public String getUserId2() {
        return userId2;
    }

    public void setUserId2(String userId2) {
        this.userId2 = userId2;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
