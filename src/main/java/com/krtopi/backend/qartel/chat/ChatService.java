package com.krtopi.backend.qartel.chat;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public ChatEntity addMessage(MessageEntity message, String chatId){
        Optional<ChatEntity> optionalChatEntity = this.chatRepository.findById(chatId);

        if (optionalChatEntity.isPresent()) {
            ChatEntity chatEntity = optionalChatEntity.get();
            // Add the new message to the existing messages array
            MessageEntity[] currentMessages = chatEntity.getMessages();
            if (currentMessages == null) {
                currentMessages = new MessageEntity[1];
                currentMessages[0] = message;
            } else {
                MessageEntity[] newMessages = Arrays.copyOf(currentMessages, currentMessages.length + 1);
                newMessages[currentMessages.length] = message;
                currentMessages = newMessages;
            }

            chatEntity.setMessages(currentMessages);
            this.chatRepository.save(chatEntity);
        }
        return optionalChatEntity.get();
    }
    public void deleteChatById(@PathVariable String chatId) {
        if (this.chatRepository.existsById(chatId)) {
            this.chatRepository.deleteById(chatId);
        } else {
            throw new IllegalArgumentException("Offer not found");
        }
    }
}
