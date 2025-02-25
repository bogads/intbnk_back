package com.bogads.intbnk_back.infrastructure.controller;

import com.bogads.intbnk_back.application.port.service.BankTransferService;
import com.bogads.intbnk_back.infrastructure.controller.request.CreateTransferRequest;
import com.bogads.intbnk_back.infrastructure.controller.response.CreateTransferResponse;
import com.bogads.intbnk_back.infrastructure.mapper.banktransfer.BankTransferMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bogads.intbnk_back.infrastructure.utils.ApiConstants.API_V1_BANK_TRANSFER;

@RestController
@RequestMapping(API_V1_BANK_TRANSFER)
public class BankTransferController {

    private final BankTransferService bankTransferService;

    public BankTransferController(BankTransferService bankTransferService) {
        this.bankTransferService = bankTransferService;
    }

    @PostMapping()
    public CreateTransferResponse createTransfer(@RequestBody @Valid CreateTransferRequest request) {
        return BankTransferMapper.toCreateTransferResponse(bankTransferService.createTransfer(BankTransferMapper.toModel(request)));
    }

}
