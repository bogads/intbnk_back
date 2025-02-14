package com.bogads.intbnk_back.application.port.repository;

import com.bogads.intbnk_back.domain.Company;

import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);
    Optional<Company> findCompanyById(String id);
}
