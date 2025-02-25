package com.bogads.intbnk_back.infrastructure.controller;

import com.bogads.intbnk_back.application.port.service.AccountService;
import com.bogads.intbnk_back.infrastructure.controller.request.CreateAccountRequest;
import com.bogads.intbnk_back.infrastructure.controller.response.CreateAccountResponse;
import com.bogads.intbnk_back.infrastructure.mapper.account.AccountMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bogads.intbnk_back.infrastructure.utils.ApiConstants.API_V1_ACCOUNT;

@RestController
@RequestMapping(API_V1_ACCOUNT)
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public CreateAccountResponse createAccount(@RequestBody @Valid CreateAccountRequest request) {
        var account = accountService.createAccount(AccountMapper.toModel(request));
        return AccountMapper.toCreateAccountResponse(account);
    }

}
