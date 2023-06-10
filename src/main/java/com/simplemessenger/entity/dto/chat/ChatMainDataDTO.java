package com.simplemessenger.entity.dto.chat;

import com.simplemessenger.entity.dto.message.MessageMainDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMainDataDTO {
    private long toAccountId;
    private List<MessageMainDataDTO> messages;
}
