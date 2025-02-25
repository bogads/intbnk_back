package com.bogads.intbnk_back.application.port.service;

import com.bogads.intbnk_back.domain.Account;

import java.util.Optional;

public interface AccountService {
    Account createAccount(Account account);

    Optional<Account> findAccountById(String id);
}
