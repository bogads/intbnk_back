package com.bogads.intbnk_back.infrastructure.adapters.service;

import com.bogads.intbnk_back.application.port.repository.BankTransferRepository;
import com.bogads.intbnk_back.application.port.service.BankTransferService;
import com.bogads.intbnk_back.domain.BankTransfer;
import org.springframework.stereotype.Service;

@Service
public class BankTransferServiceImplDB implements BankTransferService {
    private final BankTransferRepository bankTransferRepository;

    public BankTransferServiceImplDB(BankTransferRepository bankTransferRepository) {
        this.bankTransferRepository = bankTransferRepository;
    }

    @Override
    public BankTransfer createTransfer(BankTransfer bankTransfer) {
        return bankTransferRepository.save(bankTransfer);
    }
}
