package com.bogads.intbnk_back.infrastructure.controller.request;

import java.math.BigDecimal;

public class CreateTransferRequest {
    private BigDecimal amount;
    private String accountNumber;
    private String recipientAccount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }
}
