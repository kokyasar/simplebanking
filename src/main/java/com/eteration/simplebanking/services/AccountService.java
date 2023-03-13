package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

// This class is a place holder you can change the complete implementation
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findAccount(String accountNumber) {
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }
    public void createAccount(Account account){
        account.setCreateDate(LocalDateTime.now());
        accountRepository.save(account);

    }
}
