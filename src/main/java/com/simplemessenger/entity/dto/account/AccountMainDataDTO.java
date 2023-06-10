package com.simplemessenger.entity.dto.account;

import com.simplemessenger.entity.dto.chat.ChatSimpleDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountMainDataDTO {
    private String email;
    private String username;
    private String status;
    private List<ChatSimpleDataDTO> chats;
}
