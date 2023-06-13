package com.simplemessenger.controller;

import com.simplemessenger.entity.dto.chat.ChatMainDataDTO;
import com.simplemessenger.entity.dto.chat.ChatSimpleDataDTO;
import com.simplemessenger.service.ChatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatServiceImpl chatService;

    @GetMapping("/{chatId}")
    public ChatMainDataDTO getChat(@PathVariable long chatId){
        return chatService.getChat(chatId);
    }

    @GetMapping("/simple/{chatId}")
    public ChatSimpleDataDTO getSimpleChat(@PathVariable long chatId){
        return chatService.getSimpledData(chatId);
    }

    @PostMapping("/{toAccountId}")
    public void addChat(@PathVariable long toAccountId){
        chatService.addChat(toAccountId);
    }

    @DeleteMapping("/{chatId}")
    public void deleteChat(@PathVariable long chatId){
        chatService.deleteChatById(chatId);
    }
}
