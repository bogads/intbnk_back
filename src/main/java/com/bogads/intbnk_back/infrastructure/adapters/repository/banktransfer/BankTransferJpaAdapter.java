package com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer;

import com.bogads.intbnk_back.application.port.repository.BankTransferRepository;
import com.bogads.intbnk_back.domain.BankTransfer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BankTransferJpaAdapter implements BankTransferRepository {
    private final BankTransferJpaRepository repository;

    public BankTransferJpaAdapter(BankTransferJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankTransfer save(BankTransfer account) {
        return null;
    }

    @Override
    public Optional<BankTransfer> findBankTransferById(String id) {
        return Optional.empty();
    }
}
