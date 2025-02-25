package com.bogads.intbnk_back.application.port.service;

import com.bogads.intbnk_back.domain.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company companyService);
    List<Company> findCompaniesWithTransfersLastMonth();
    List<Company> findCompaniesJoinedLastMonth();
}
