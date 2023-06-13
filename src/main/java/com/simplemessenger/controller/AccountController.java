package com.simplemessenger.controller;

import com.simplemessenger.entity.dto.account.AccountMainDataDTO;
import com.simplemessenger.entity.dto.account.AccountUpdateDTO;
import com.simplemessenger.service.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountService;

    @GetMapping("/{id}")
    public AccountMainDataDTO getUser(@PathVariable long id){
        return accountService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id, @RequestBody AccountUpdateDTO accountDTO){
        accountService.update(id, accountDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        accountService.deleteAccountById(id);
    }
}
