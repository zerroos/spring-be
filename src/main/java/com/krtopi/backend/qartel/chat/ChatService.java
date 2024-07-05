package com.krtopi.backend.qartel.chat;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ChatService {
    private ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository){
        this.chatRepository = chatRepository;
    }

    public ChatEntity createChat(ChatEntity chat) {
        return this.chatRepository.save(chat);
    }

    // GET /api/chats?userId={userId}
    @GetMapping("/api/chats")
    public List<ChatEntity> getChatsByUserId(@RequestParam String userId) {
        return this.chatRepository.findByUserId1OrUserId2(userId);
    }

    public ChatEntity getChatById(String chatId) {
        return this.chatRepository.findByConversationId(chatId);
    }

    public ChatEntity addMessage(MessageEntity message){
        return null;
    }
    public void deleteChatById(@PathVariable String chatId) {
        if (this.chatRepository.existsById(chatId)) {
            this.chatRepository.deleteById(chatId);
        } else {
            throw new IllegalArgumentException("Offer not found");
        }
    }
}
