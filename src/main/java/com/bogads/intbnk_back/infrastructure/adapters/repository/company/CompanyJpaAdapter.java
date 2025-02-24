package com.bogads.intbnk_back.infrastructure.adapters.repository.company;

import com.bogads.intbnk_back.application.port.repository.CompanyRepository;
import com.bogads.intbnk_back.domain.Company;
import com.bogads.intbnk_back.infrastructure.mapper.company.CompanyMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
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
        var persistedEntity = repository.save(entity);
        return CompanyMapper.toModel(persistedEntity);
    }

    @Override
    public List<Company> findCompaniesWithTransfersLastMonth() {

        var now = LocalDateTime.now();
        return repository.findCompaniesWithTransfersLastMonth(now.minusMonths(1))
                .stream()
                .map(CompanyMapper::toModel)
                .toList();
    }

    @Override
    public List<Company> findCompaniesJoinedLastMonth() {
        var now = LocalDateTime.now();
        return repository.findByAdhesionTimeAfter(now.minus(1, java.time.temporal.ChronoUnit.MONTHS))
                .stream()
                .map(CompanyMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Company> findCompanyById(String id) {
        var optCompany = repository.findById(id);
        return optCompany.map(CompanyMapper::toModel);
    }
}
