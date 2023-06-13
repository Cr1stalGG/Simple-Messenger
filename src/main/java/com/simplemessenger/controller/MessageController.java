package com.simplemessenger.controller;

import com.simplemessenger.entity.dto.message.MessageMainDataDTO;
import com.simplemessenger.entity.dto.message.MessageUpdateDTO;
import com.simplemessenger.entity.dto.message.SendMessageDTO;
import com.simplemessenger.service.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats/{chatId}")
@RequiredArgsConstructor
public class MessageController {
    private final MessageServiceImpl messageService;

    @GetMapping("/find/{message}")
    public List<MessageMainDataDTO> findAllMessagesByMessage(@PathVariable long chatId, @PathVariable String message){
        return messageService.getAllMessagesByMessage(message);
    }

    @PostMapping("/message")
    public void sendMessage(@PathVariable long chatId, @RequestBody SendMessageDTO messageDTO){
        messageService.sendMessage(chatId, messageDTO);
    }

    @PutMapping("/{messageId}")
    public void updateMessage(@PathVariable long chatId, @PathVariable long messageId, @RequestBody MessageUpdateDTO messageDTO){
        messageService.updateMessage(messageId, messageDTO);
    }

    @DeleteMapping("/{messageId}")
    public void deleteMessage(@PathVariable long messageId, @PathVariable String chatId){
        messageService.deleteMessageById(messageId);
    }
}
