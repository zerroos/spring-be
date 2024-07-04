package com.krtopi.backend.qartel.chat;

import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository){
        this.chatRepository = chatRepository;
    }
}
