package com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableRepository;
import com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer.entity.BankTransferEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BankTransferJpaRepository extends SoftDeletableRepository<BankTransferEntity> {
}
