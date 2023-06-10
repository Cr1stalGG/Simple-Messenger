package com.simplemessenger.entity.dto.convertor;

import com.simplemessenger.entity.Account;
import com.simplemessenger.entity.dto.account.AccountMainDataDTO;
import com.simplemessenger.entity.dto.security.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountDTOConvertor {
    private final ChatDTOConvertor chatDTOConvertor;

    public AccountMainDataDTO convertEntityToMainData(Account account){
        AccountMainDataDTO accountDTO = new AccountMainDataDTO();

        accountDTO.setEmail(account.getEmail());
        if(account.getUsername() != null)
            accountDTO.setUsername(account.getUsername());
        if(account.getStatus() != null)
            accountDTO.setStatus(account.getStatus());
        if(!account.getChats().isEmpty())
            accountDTO.setChats(account.getChats().stream().map(chatDTOConvertor::convertEntityToSimpleData).toList());

        return accountDTO;
    }

    public Account convertRegistrationRequestToEntity(RegistrationRequest accountDTO) {
        Account account = new Account();

        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());

        return account;
    }
}
