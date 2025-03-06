package com.bogads.intbnk_back.infrastructure.adapters.repository.account;

import com.bogads.intbnk_back.domain.Account;
import com.bogads.intbnk_back.infrastructure.adapters.repository.account.entity.AccountEntity;
import com.bogads.intbnk_back.infrastructure.mapper.account.AccountMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountJpaAdapterTest {

    private AccountJpaRepository repository;
    private AccountJpaAdapter accountJpaAdapter;

    @BeforeEach
    void setUp() {
        repository = mock(AccountJpaRepository.class);
        accountJpaAdapter = new AccountJpaAdapter(repository);
    }

    @Test
    void testSave_Success() {
        Account account = new Account();
        account.setId("12345");
        account.setNumber("678910");

        var mockedEntity = AccountMapper.toEntity(account);
        when(repository.save(any(AccountEntity.class))).thenReturn(mockedEntity);

        Account savedAccount = accountJpaAdapter.save(account);

        assertNotNull(savedAccount);
        assertEquals("12345", savedAccount.getId());
        verify(repository, times(1)).save(any(AccountEntity.class));
    }

    @Test
    void testFindAccountById_AlwaysEmpty() {
        Optional<Account> result = accountJpaAdapter.findAccountById("12345");

        assertTrue(result.isEmpty(), "El método debe devolver Optional.empty() según su implementación actual.");
        verifyNoInteractions(repository);
    }
}