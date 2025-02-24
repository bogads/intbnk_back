package com.bogads.intbnk_back.infrastructure.controller;

import com.bogads.intbnk_back.infrastructure.controller.request.CreateTransferRequest;
import com.bogads.intbnk_back.infrastructure.controller.response.CreateTransferResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bogads.intbnk_back.infrastructure.utils.ApiConstants.API_V1_BANK_TRANSFER;

@RestController
@RequestMapping(API_V1_BANK_TRANSFER)
public class BankTransferController {


    @PostMapping()
    public CreateTransferResponse createTransfer(@RequestBody @Valid CreateTransferRequest request) {
        return new CreateTransferResponse();
    }

}
