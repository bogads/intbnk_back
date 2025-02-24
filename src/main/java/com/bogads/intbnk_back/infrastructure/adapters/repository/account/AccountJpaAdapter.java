package com.bogads.intbnk_back.infrastructure.adapters.repository.account;

import com.bogads.intbnk_back.application.port.repository.AccountRepository;
import com.bogads.intbnk_back.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountJpaAdapter implements AccountRepository {

    private final AccountJpaRepository repository;

    public AccountJpaAdapter(AccountJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Optional<Account> findAccountById(String id) {
        return Optional.empty();
    }
}
