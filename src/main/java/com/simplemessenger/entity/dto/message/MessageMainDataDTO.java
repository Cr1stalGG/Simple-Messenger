package com.simplemessenger.entity.dto.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageMainDataDTO {
    private String senderUsername;
    private String message;
    private Date date;
}
