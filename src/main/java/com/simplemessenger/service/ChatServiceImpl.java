package com.simplemessenger.service;

import com.simplemessenger.entity.Account;
import com.simplemessenger.entity.Chat;
import com.simplemessenger.entity.dto.chat.ChatMainDataDTO;
import com.simplemessenger.entity.dto.chat.ChatSimpleDataDTO;
import com.simplemessenger.entity.dto.convertor.ChatDTOConvertor;
import com.simplemessenger.repository.AccountRepository;
import com.simplemessenger.repository.ChatRepository;
import com.simplemessenger.service.api.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;
    private final AccountRepository accountRepository;
    private final ChatDTOConvertor chatDTOConvertor;

    @Override
    public void addChat(long toAccountId) {
        Chat chat = new Chat();

        chat.setFromAccount((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        chat.setToAccount(accountRepository.findById(toAccountId));

        chatRepository.save(chat);
    }

    @Override
    public ChatMainDataDTO getChat(long chatId) {
            return chatDTOConvertor.convertEntityToMainData(chatRepository.findById(chatId));
    }

    @Override
    public ChatSimpleDataDTO getSimpledData(long chatId) {
        Chat chat = chatRepository.findById(chatId);

        return chatDTOConvertor.convertEntityToSimpleData(chat);
    }

    @Override
    public void deleteChatById(long chatId) {
        chatRepository.deleteById(chatId);
    }
}
