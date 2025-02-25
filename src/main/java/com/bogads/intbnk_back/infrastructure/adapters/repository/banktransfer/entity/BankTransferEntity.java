package com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer.entity;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableEntity;
import com.bogads.intbnk_back.infrastructure.adapters.repository.account.entity.AccountEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "bank_transfers")
public class BankTransferEntity extends SoftDeletableEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_id")
    private AccountEntity source;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "target_id")
    private AccountEntity target;
    @Column
    private BigDecimal amount;

    public AccountEntity getSource() {
        return source;
    }

    public void setSource(AccountEntity sender) {
        this.source = sender;
    }

    public AccountEntity getTarget() {
        return target;
    }

    public void setTarget(AccountEntity receiver) {
        this.target = receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }
}
