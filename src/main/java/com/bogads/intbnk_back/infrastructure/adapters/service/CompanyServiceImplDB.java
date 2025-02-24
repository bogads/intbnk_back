package com.bogads.intbnk_back.infrastructure.adapters.service;

import com.bogads.intbnk_back.application.port.repository.CompanyRepository;
import com.bogads.intbnk_back.application.port.service.CompanyService;
import com.bogads.intbnk_back.domain.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImplDB implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImplDB(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }
}
