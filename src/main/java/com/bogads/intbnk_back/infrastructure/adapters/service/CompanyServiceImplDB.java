package com.bogads.intbnk_back.infrastructure.adapters.service;

import com.bogads.intbnk_back.application.port.repository.CompanyRepository;
import com.bogads.intbnk_back.application.port.service.CompanyService;
import com.bogads.intbnk_back.domain.Company;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyServiceImplDB implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImplDB(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company createCompany(Company company) {
        companyRepository.findCompanyByCuitAndName(company.getCuit(), company.getName())
                .ifPresent(c -> {
                    throw new IllegalStateException("Company already exists");
                });
        company.setAdhesionTime(LocalDateTime.now());
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findCompaniesWithTransfersLastMonth() {
        return companyRepository.findCompaniesWithTransfersLastMonth();
    }

    @Override
    public List<Company> findCompaniesJoinedLastMonth() {
        return companyRepository.findCompaniesJoinedLastMonth();
    }

}
