package com.simplemessenger.service.api;

import com.simplemessenger.entity.dto.chat.ChatMainDataDTO;
import com.simplemessenger.entity.dto.chat.ChatSimpleDataDTO;

public interface ChatService {
    void addChat(long toAccountId);
    ChatMainDataDTO getChat(long chatId);
    ChatSimpleDataDTO getSimpledData(long chatId);
    void deleteChatById(long chatId);
}
