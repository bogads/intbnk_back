package com.bogads.intbnk_back.infrastructure.adapters.service;


import com.bogads.intbnk_back.application.port.repository.AccountRepository;
import com.bogads.intbnk_back.domain.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceImplDBTest {

    private AccountRepository accountRepository;
    private AccountServiceImplDB accountService;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        accountService = new AccountServiceImplDB(accountRepository);
    }

    @Test
    void testCreateAccount_Success() {
        Account account = new Account();

        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Account createdAccount = accountService.createAccount(account);

        assertNotNull(createdAccount.getNumber(), "El número de cuenta debería generarse automáticamente");
        assertDoesNotThrow(() -> UUID.fromString(createdAccount.getNumber()),
                "El número generado debe tener un formato UUID válido");

        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void testFindAccountById_Found() {
        String accountId = "12345";
        Account mockAccount = new Account();
        mockAccount.setId(accountId);

        when(accountRepository.findAccountById(accountId)).thenReturn(Optional.of(mockAccount));

        Optional<Account> result = accountService.findAccountById(accountId);

        assertTrue(result.isPresent(), "La cuenta debería estar presente");
        assertEquals(accountId, result.get().getId(), "El ID de la cuenta obtenida debería coincidir");
        verify(accountRepository, times(1)).findAccountById(accountId);
    }

    @Test
    void testFindAccountById_NotFound() {
        String accountId = "12345";
        when(accountRepository.findAccountById(accountId)).thenReturn(Optional.empty());
        Optional<Account> result = accountService.findAccountById(accountId);
        assertTrue(result.isEmpty(), "La cuenta no debería estar presente");
        verify(accountRepository, times(1)).findAccountById(accountId);
    }
}