package com.bogads.intbnk_back.infrastructure.adapters.service;

import com.bogads.intbnk_back.application.port.AccountService;
import com.bogads.intbnk_back.application.port.repository.AccountRepository;
import com.bogads.intbnk_back.domain.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImplDB implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImplDB(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findAccountById(String id) {
        return Optional.empty();
    }
}
