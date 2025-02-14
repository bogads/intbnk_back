package com.bogads.intbnk_back.infrastructure.adapters.repository.company;

import com.bogads.intbnk_back.application.port.repository.CompanyRepository;
import com.bogads.intbnk_back.domain.Company;
import com.bogads.intbnk_back.infrastructure.mapper.company.CompanyMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyJpaAdapter implements CompanyRepository {
    private final CompanyJpaRepository repository;

    public CompanyJpaAdapter(CompanyJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company save(Company company) {
        var entity = CompanyMapper.toEntity(company);
        return null;
    }

    @Override
    public Optional<Company> findCompanyById(String id) {
        return Optional.empty();
    }
}
