package com.bogads.intbnk_back.infrastructure.mapper.banktransfer;

import com.bogads.intbnk_back.domain.Account;
import com.bogads.intbnk_back.domain.BankTransfer;
import com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer.entity.BankTransferEntity;
import com.bogads.intbnk_back.infrastructure.controller.request.CreateTransferRequest;
import com.bogads.intbnk_back.infrastructure.controller.response.CreateTransferResponse;
import com.bogads.intbnk_back.infrastructure.mapper.account.AccountMapper;

public class BankTransferMapper {

    private BankTransferMapper() {
    }


    public static BankTransfer toModel(BankTransferEntity request) {
        var bankTransfer = new BankTransfer();
        bankTransfer.setId(request.getId());
        bankTransfer.setAmount(request.getAmount());
        bankTransfer.setTargetAccountId(request.getTarget().getId());
        bankTransfer.setSourceAccountId(request.getSource().getId());
        if (request.getSource() != null) {
            Account sourceAccount = new Account();
            sourceAccount.setId(request.getSource().getId());
            bankTransfer.setSourceAccount(sourceAccount);
        }
        if (request.getTarget() != null) {
            Account targetAccount = new Account();
            targetAccount.setId(request.getTarget().getId());
            bankTransfer.setTargetAccount(targetAccount);
        }
        return bankTransfer;
    }

    public static BankTransfer toModel(CreateTransferRequest request) {
        var bankTransfer = new BankTransfer();
        bankTransfer.setAmount(request.getAmount());
        bankTransfer.setTargetAccountId(request.getTargetAccountId());
        bankTransfer.setSourceAccountId(request.getSourceAccountId());
        Account sourceAccount = new Account();
        sourceAccount.setId(request.getSourceAccountId());
        bankTransfer.setSourceAccount(sourceAccount);
        Account targetAccount = new Account();
        targetAccount.setId(request.getTargetAccountId());
        bankTransfer.setTargetAccount(targetAccount);
        return bankTransfer;
    }

    public static CreateTransferResponse toCreateTransferResponse(BankTransfer transfer) {
        var response = new CreateTransferResponse();
        response.setId(transfer.getId());
        return response;
    }

    public static BankTransferEntity toEntity(BankTransfer model) {
        BankTransferEntity entity = new BankTransferEntity();
        entity.setId(model.getId());
        entity.setAmount(model.getAmount());
        entity.setTarget(AccountMapper.toEntity(model.getTargetAccount()));
        entity.setSource(AccountMapper.toEntity(model.getSourceAccount()));
        return entity;
    }
}
