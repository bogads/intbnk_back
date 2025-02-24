package com.bogads.intbnk_back.infrastructure.adapters.repository.account.entity;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableEntity;
import com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer.entity.BankTransferEntity;
import com.bogads.intbnk_back.infrastructure.adapters.repository.company.entity.CompanyEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "account")
public class AccountEntity extends SoftDeletableEntity {
    private String accountNumber;
    @ManyToOne
    private CompanyEntity company;
    @OneToMany
    private List<BankTransferEntity> sender;
    @OneToMany
    private List<BankTransferEntity> receiver;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public List<BankTransferEntity> getSender() {
        return sender;
    }

    public void setSender(List<BankTransferEntity> sender) {
        this.sender = sender;
    }

    public List<BankTransferEntity> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<BankTransferEntity> receiver) {
        this.receiver = receiver;
    }
}
