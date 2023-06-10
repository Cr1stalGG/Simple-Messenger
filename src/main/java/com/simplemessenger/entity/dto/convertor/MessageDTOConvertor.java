package com.simplemessenger.entity.dto.convertor;

import com.simplemessenger.entity.Message;
import com.simplemessenger.entity.dto.message.MessageMainDataDTO;
import com.simplemessenger.entity.dto.message.SendMessageDTO;
import com.simplemessenger.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageDTOConvertor {
    private final AccountRepository accountRepository;
    public MessageMainDataDTO convertEntityToMainDataDTO(Message message) {
        MessageMainDataDTO messageDTO = new MessageMainDataDTO();

        messageDTO.setSenderUsername(accountRepository.findById(message.getSenderId()).getUsername());
        if(message.getMessage() != null)
            messageDTO.setMessage(message.getMessage());
        messageDTO.setDate(message.getDate());

        return messageDTO;
    }

    public Message convertSendMessageDTOToEntity(SendMessageDTO messageDTO){
        Message message = new Message();

        if(messageDTO.getMessage() != null)
            message.setMessage(messageDTO.getMessage());
        if(messageDTO.getSenderId() != 0)
            message.setSenderId(messageDTO.getSenderId());


        return message;
    }
}
