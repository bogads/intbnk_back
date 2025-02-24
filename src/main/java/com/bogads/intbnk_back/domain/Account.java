package com.bogads.intbnk_back.domain;

import java.util.List;

public class Account {
    private String id;
    private String number;
    private List<BankTransfer> sender;
    private List<BankTransfer> receiver;
    private Company company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BankTransfer> getSender() {
        return sender;
    }

    public void setSender(List<BankTransfer> sender) {
        this.sender = sender;
    }

    public List<BankTransfer> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<BankTransfer> receiver) {
        this.receiver = receiver;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

