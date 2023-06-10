package com.simplemessenger.entity.dto.convertor;

import com.simplemessenger.entity.Chat;
import com.simplemessenger.entity.dto.chat.ChatMainDataDTO;
import com.simplemessenger.entity.dto.chat.ChatSimpleDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatDTOConvertor {
    private final MessageDTOConvertor messageDTOConvertor;
    public ChatSimpleDataDTO convertEntityToSimpleData(Chat chat){
        ChatSimpleDataDTO chatDTO = new ChatSimpleDataDTO();

        if(chat.getToAccount().getUsername() != null)
            chatDTO.setToAccountUsername(chat.getToAccount().getUsername());
        if(!chat.getMessages().isEmpty() && chat.getMessages().get(chat.getMessages().size()-1) != null)
            chatDTO.setLastMessage(messageDTOConvertor.convertEntityToMainDataDTO(chat.getMessages().get(chat.getMessages().size()-1)));

        return chatDTO;
    }

    public ChatMainDataDTO convertEntityToMainData(Chat chat){
        ChatMainDataDTO chatDTO = new ChatMainDataDTO();

        if(!chat.getMessages().isEmpty())
            chatDTO.setMessages(chat.getMessages().stream().map(messageDTOConvertor::convertEntityToMainDataDTO).toList());
        chatDTO.setToAccountId(chat.getToAccount().getId());

        return chatDTO;
    }
}
