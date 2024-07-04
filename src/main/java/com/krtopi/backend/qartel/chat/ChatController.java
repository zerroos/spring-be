package com.krtopi.backend.qartel.chat;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/chats")
public class ChatController {
    private ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }
    // POST /api/chat
    @PostMapping("/api/chat")
    public ChatEntity createChat(@RequestBody ChatEntity chat) {
        return chatService.createChat(chat);
    }

    // GET /api/chats?userId={userId}
    @GetMapping("/api/chats")
    public List<ChatEntity> getChatsByUserId(@RequestParam String userId) {
        return chatService.getChatsByUserId(userId);
    }

    // GET /api/chats/{chatId}
    @GetMapping("/api/chats/{chatId}")
    public ChatEntity getChatById(@PathVariable String chatId) {
        return chatService.getChatById(chatId);
    }

    // DELETE /api/chats/{chatId}
    @DeleteMapping("/api/chats/{chatId}")
    public void deleteChatById(@PathVariable String chatId) {
        chatService.deleteChatById(chatId);
    }
}
