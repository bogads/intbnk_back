package com.bogads.intbnk_back.application.port.repository;

import com.bogads.intbnk_back.domain.Account;

import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);

    Optional<Account> findAccountById(String id);
}
