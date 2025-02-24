package com.bogads.intbnk_back.application.port.repository;

import com.bogads.intbnk_back.domain.BankTransfer;

import java.util.Optional;

public interface BankTransferRepository {
    BankTransfer save(BankTransfer account);

    Optional<BankTransfer> findBankTransferById(String id);
}
