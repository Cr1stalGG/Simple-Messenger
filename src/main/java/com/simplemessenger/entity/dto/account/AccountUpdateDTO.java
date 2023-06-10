package com.simplemessenger.entity.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdateDTO {
    private String email;
    private String password;
    private String username;
    private String status;
}
