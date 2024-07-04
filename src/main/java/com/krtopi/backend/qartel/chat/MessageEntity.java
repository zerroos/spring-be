package com.krtopi.backend.qartel.chat;

import jakarta.persistence.Id;

import java.util.Date;

public class MessageEntity {
    @Id
    private String messageId;
    private String senderId;
    private String chatId;
    private String messageText;
    private Date timestamp;

}
