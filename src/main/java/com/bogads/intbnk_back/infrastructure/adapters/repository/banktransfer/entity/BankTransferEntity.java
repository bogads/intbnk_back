package com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer.entity;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableEntity;
import com.bogads.intbnk_back.infrastructure.adapters.repository.account.entity.AccountEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "bank_transfers")
public class BankTransferEntity extends SoftDeletableEntity {
    @ManyToOne
    private AccountEntity sender;
    @ManyToOne
    private AccountEntity receiver;

    public AccountEntity getSender() {
        return sender;
    }

    public void setSender(AccountEntity sender) {
        this.sender = sender;
    }

    public AccountEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(AccountEntity receiver) {
        this.receiver = receiver;
    }
}
