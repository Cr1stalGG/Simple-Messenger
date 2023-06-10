package com.simplemessenger.service;

import com.simplemessenger.entity.Account;
import com.simplemessenger.entity.dto.account.AccountMainDataDTO;
import com.simplemessenger.entity.dto.account.AccountUpdateDTO;
import com.simplemessenger.entity.dto.convertor.AccountDTOConvertor;
import com.simplemessenger.entity.dto.security.RegistrationRequest;
import com.simplemessenger.repository.AccountRepository;
import com.simplemessenger.service.api.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountDTOConvertor accountDTOConvertor;

    @Override
    public void addAccount(RegistrationRequest accountDTO) {
        Account account = accountDTOConvertor.convertRegistrationRequestToEntity(accountDTO);

        accountRepository.save(account);
    }

    @Override
    public AccountMainDataDTO getById(long id) {
        return accountDTOConvertor.convertEntityToMainData(accountRepository.findById(id));
    }

    @Override
    public void update(long id, AccountUpdateDTO accountDTO) {
        Account account = accountRepository.findById(id);

        if(accountDTO.getEmail() != null) account.setEmail(accountDTO.getEmail());
        if(accountDTO.getPassword() != null) account.setPassword(accountDTO.getPassword());
        if(accountDTO.getUsername() != null) account.setUsername(accountDTO.getUsername());
        if(accountDTO.getStatus() != null) account.setStatus(accountDTO.getStatus());

        accountRepository.save(account);
    }

    @Override
    public void deleteAccountById(long id) {
        accountRepository.deleteById(id);
    }
}
