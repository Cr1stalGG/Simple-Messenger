package com.simplemessenger.service;

import com.simplemessenger.entity.Chat;
import com.simplemessenger.entity.Message;
import com.simplemessenger.entity.dto.convertor.MessageDTOConvertor;
import com.simplemessenger.entity.dto.message.MessageMainDataDTO;
import com.simplemessenger.entity.dto.message.MessageUpdateDTO;
import com.simplemessenger.entity.dto.message.SendMessageDTO;
import com.simplemessenger.repository.ChatRepository;
import com.simplemessenger.repository.MessageRepository;
import com.simplemessenger.service.api.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final MessageDTOConvertor messageDTOConvertor;

    @Override
    public void sendMessage(long chatId, SendMessageDTO messageDTO) {
        Chat chat = chatRepository.findById(chatId);

        chat.getMessages().add(messageDTOConvertor.convertSendMessageDTOToEntity(messageDTO));

        chatRepository.save(chat);
    }

    @Override
    public List<MessageMainDataDTO> getAllMessagesByMessage(String message){
        List<Message> messageList = messageRepository.findAllByMessage(message);

        return messageList.stream().map(messageDTOConvertor::convertEntityToMainDataDTO).toList();
    }

    @Override
    public void updateMessage(long messageId, MessageUpdateDTO messageDTO) {
        Message message = messageRepository.findById(messageId);

        if(messageDTO.getMessage() != null)
            message.setMessage(messageDTO.getMessage());

        Date date = new Date();
        message.setDate(new java.sql.Date(date.getTime()));

        messageRepository.save(message);
    }

    @Override
    public void deleteMessageById(long messageId) {
        messageRepository.deleteById(messageId);
    }
}
