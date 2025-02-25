package com.bogads.intbnk_back.application.port.service;

import com.bogads.intbnk_back.domain.BankTransfer;

public interface BankTransferService {
    BankTransfer createTransfer(BankTransfer model);
}
