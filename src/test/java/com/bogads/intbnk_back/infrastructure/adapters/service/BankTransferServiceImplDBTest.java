package com.bogads.intbnk_back.infrastructure.adapters.service;

import com.bogads.intbnk_back.application.port.repository.BankTransferRepository;
import com.bogads.intbnk_back.domain.Account;
import com.bogads.intbnk_back.domain.BankTransfer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BankTransferServiceImplDBTest {

    private BankTransferRepository bankTransferRepository;
    private BankTransferServiceImplDB bankTransferService;

    @BeforeEach
    void setup() {
        bankTransferRepository = mock(BankTransferRepository.class);
        bankTransferService = new BankTransferServiceImplDB(bankTransferRepository);
    }

    @Test
    void testCreateTransfer_Success() {
        BankTransfer bankTransfer = new BankTransfer();
        bankTransfer.setId("1L");
        var sourceAccount = new Account();
        sourceAccount.setId("12345");
        var targetAccount = new Account();
        targetAccount.setId("54321");
        bankTransfer.setSourceAccount(sourceAccount);
        bankTransfer.setTargetAccount(targetAccount);
        bankTransfer.setAmount(BigDecimal.valueOf(1000.0));

        when(bankTransferRepository.save(bankTransfer)).thenReturn(bankTransfer);

        BankTransfer savedTransfer = bankTransferService.createTransfer(bankTransfer);

        verify(bankTransferRepository, times(1)).save(bankTransfer);
        assertNotNull(savedTransfer);
        assertEquals("1L", savedTransfer.getId());
        assertEquals("12345", savedTransfer.getSourceAccount().getId());
        assertEquals("54321", savedTransfer.getTargetAccount().getId());
        assertEquals(BigDecimal.valueOf(1000.0), savedTransfer.getAmount());
    }
}