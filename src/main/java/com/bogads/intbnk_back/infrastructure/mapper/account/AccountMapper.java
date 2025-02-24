package com.bogads.intbnk_back.infrastructure.mapper.account;

import com.bogads.intbnk_back.domain.Account;
import com.bogads.intbnk_back.domain.Company;
import com.bogads.intbnk_back.infrastructure.adapters.repository.account.entity.AccountEntity;
import com.bogads.intbnk_back.infrastructure.controller.request.CreateAccountRequest;
import com.bogads.intbnk_back.infrastructure.controller.response.CreateAccountResponse;
import com.bogads.intbnk_back.infrastructure.mapper.company.CompanyMapper;

public final class AccountMapper {
    private AccountMapper() {
    }

    public static Account toModel(AccountEntity account) {
        var accountModel = new Account();
        accountModel.setId(account.getId());
        //TODO implement all attributes
        return accountModel;
    }
    public static Account toModel(CreateAccountRequest request) {
        var accountModel = new Account();
        var company = new Company();
        company.setId(request.getCompanyId());
        accountModel.setCompany(company);
        return accountModel;
    }

    public static CreateAccountResponse toCreateAccountResponse(Account account) {
        var response = new CreateAccountResponse();
        response.setId(account.getId());
        return response;
    }

    public static AccountEntity toEntity(Account account) {
        var entity = new AccountEntity();
        entity.setId(account.getId());
        entity.setAccountNumber(account.getNumber());
        entity.setCompany(CompanyMapper.toEntity(account.getCompany()));
        //TODO add transfer list
        return entity;
    }
}
