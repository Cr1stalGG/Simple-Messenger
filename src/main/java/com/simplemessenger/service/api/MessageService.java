package com.simplemessenger.service.api;

import com.simplemessenger.entity.dto.message.MessageMainDataDTO;
import com.simplemessenger.entity.dto.message.MessageUpdateDTO;
import com.simplemessenger.entity.dto.message.SendMessageDTO;

import java.util.List;

public interface MessageService {
    void sendMessage(long chatId, SendMessageDTO message);

    List<MessageMainDataDTO> getAllMessagesByMessage(String message);

    void updateMessage(long messageId, MessageUpdateDTO messageDTO);
    void deleteMessageById(long messageId);
}
