package com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer;

import com.bogads.intbnk_back.domain.Account;
import com.bogads.intbnk_back.domain.BankTransfer;
import com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer.entity.BankTransferEntity;
import com.bogads.intbnk_back.infrastructure.mapper.banktransfer.BankTransferMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BankTransferJpaAdapterTest {

    private BankTransferJpaRepository repository;
    private BankTransferJpaAdapter bankTransferJpaAdapter;

    @BeforeEach
    void setUp() {
        repository = mock(BankTransferJpaRepository.class);
        bankTransferJpaAdapter = new BankTransferJpaAdapter(repository);
    }

    @Test
    void testSave_Success() {
        BankTransfer bankTransfer = new BankTransfer();
        bankTransfer.setId("12345");

        var sourceAccount = new Account();
        sourceAccount.setId("11111");
        bankTransfer.setSourceAccount(sourceAccount);

        var targetAccount = new Account();
        targetAccount.setId("22222");
        bankTransfer.setTargetAccount(targetAccount);

        bankTransfer.setAmount(BigDecimal.valueOf(1000.0));

        var mockedEntity = BankTransferMapper.toEntity(bankTransfer);
        when(repository.save(any(BankTransferEntity.class))).thenReturn(mockedEntity);

        BankTransfer savedBankTransfer = bankTransferJpaAdapter.save(bankTransfer);

        assertNotNull(savedBankTransfer, "El objeto guardado no debería ser nulo");
        assertEquals("12345", savedBankTransfer.getId());
        assertEquals("11111", savedBankTransfer.getSourceAccount().getId());
        assertEquals("22222", savedBankTransfer.getTargetAccount().getId());
        assertEquals(BigDecimal.valueOf(1000.0), savedBankTransfer.getAmount());
        verify(repository, times(1)).save(any(BankTransferEntity.class));
    }

    @Test
    void testFindBankTransferById_AlwaysEmpty() {
        Optional<BankTransfer> result = bankTransferJpaAdapter.findBankTransferById("12345");

        assertTrue(result.isEmpty(), "El método debe devolver Optional.empty() según su implementación actual.");
        verifyNoInteractions(repository);
    }
}