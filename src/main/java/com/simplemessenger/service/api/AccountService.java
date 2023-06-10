package com.simplemessenger.service.api;

import com.simplemessenger.entity.dto.account.AccountMainDataDTO;
import com.simplemessenger.entity.dto.account.AccountUpdateDTO;
import com.simplemessenger.entity.dto.security.RegistrationRequest;

public interface AccountService {
    void addAccount(RegistrationRequest accountDTO);
    AccountMainDataDTO getById(long id);
    void update(long id, AccountUpdateDTO accountDTO);
    void deleteAccountById(long id);
}
