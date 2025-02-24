package com.bogads.intbnk_back.infrastructure.adapters.repository.account;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableRepository;
import com.bogads.intbnk_back.infrastructure.adapters.repository.account.entity.AccountEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends SoftDeletableRepository<AccountEntity> {

}
