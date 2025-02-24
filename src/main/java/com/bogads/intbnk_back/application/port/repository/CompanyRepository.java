package com.bogads.intbnk_back.application.port.repository;

import com.bogads.intbnk_back.domain.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);
    List<Company> findCompaniesWithTransfersLastMonth();
    List<Company> findCompaniesJoinedLastMonth();
    Optional<Company> findCompanyById(String id);
}
