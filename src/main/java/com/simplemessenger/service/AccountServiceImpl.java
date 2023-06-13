package com.simplemessenger.service;

import com.simplemessenger.entity.Account;
import com.simplemessenger.entity.dto.account.AccountMainDataDTO;
import com.simplemessenger.entity.dto.account.AccountUpdateDTO;
import com.simplemessenger.entity.dto.convertor.AccountDTOConvertor;
import com.simplemessenger.entity.dto.security.LoginRequest;
import com.simplemessenger.entity.dto.security.RegistrationRequest;
import com.simplemessenger.entity.enumiration.Role;
import com.simplemessenger.repository.AccountRepository;
import com.simplemessenger.security.AuthenticationResponse;
import com.simplemessenger.security.JwtService;
import com.simplemessenger.service.api.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountDTOConvertor accountDTOConvertor;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse addAccount(RegistrationRequest accountDTO) {
        Account account = Account.builder()
                .email(accountDTO.getEmail())
                .password(passwordEncoder.encode(accountDTO.getPassword()))
                .role(Role.USER)
                .build();

        accountRepository.save(account);

        var jwtToken = jwtService.generateToken(account);

        return AuthenticationResponse.builder().token(jwtToken).build();

    }

    @Override
    public AuthenticationResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        Account user = Optional.ofNullable(accountRepository.findByEmail(request.getEmail())).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();

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
