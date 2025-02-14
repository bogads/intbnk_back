package com.bogads.intbnk_back.infrastructure.adapters.repository.company;

import com.bogads.intbnk_back.application.port.repository.CompanyRepository;
import com.bogads.intbnk_back.domain.Company;
import com.bogads.intbnk_back.infrastructure.mapper.company.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CompanyJpaAdapter implements CompanyRepository {
    private final CompanyJpaRepository repository;

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
