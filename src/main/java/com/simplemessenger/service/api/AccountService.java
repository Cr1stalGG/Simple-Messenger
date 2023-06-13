package com.simplemessenger.service.api;

import com.simplemessenger.entity.dto.account.AccountMainDataDTO;
import com.simplemessenger.entity.dto.account.AccountUpdateDTO;
import com.simplemessenger.entity.dto.security.LoginRequest;
import com.simplemessenger.entity.dto.security.RegistrationRequest;
import com.simplemessenger.security.AuthenticationResponse;

public interface AccountService {
    AuthenticationResponse addAccount(RegistrationRequest accountDTO);
    AuthenticationResponse authenticate(LoginRequest request);
    AccountMainDataDTO getById(long id);
    void update(long id, AccountUpdateDTO accountDTO);
    void deleteAccountById(long id);
}
