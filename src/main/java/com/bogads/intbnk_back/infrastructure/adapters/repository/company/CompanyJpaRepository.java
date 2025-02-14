package com.bogads.intbnk_back.infrastructure.adapters.repository.company;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableRepository;
import com.bogads.intbnk_back.infrastructure.adapters.repository.company.entity.CompanyEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends SoftDeletableRepository<CompanyEntity> {
}
