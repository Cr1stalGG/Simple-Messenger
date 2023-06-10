package com.simplemessenger.entity.dto.chat;

import com.simplemessenger.entity.dto.message.MessageMainDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatSimpleDataDTO {
    private String toAccountUsername;
    private MessageMainDataDTO lastMessage;
}
