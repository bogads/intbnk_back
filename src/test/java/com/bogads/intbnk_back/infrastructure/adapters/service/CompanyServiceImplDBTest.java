package com.bogads.intbnk_back.infrastructure.adapters.service;

import com.bogads.intbnk_back.application.port.repository.CompanyRepository;
import com.bogads.intbnk_back.domain.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CompanyServiceImplDBTest {

    private CompanyRepository companyRepository;
    private CompanyServiceImplDB companyService;

    @BeforeEach
    void setup() {
        companyRepository = mock(CompanyRepository.class);
        companyService = new CompanyServiceImplDB(companyRepository);
    }

    @Test
    void testCreateCompany_Success() {
        Company company = new Company();
        company.setCuit("123456789");
        company.setName("Valid Company");

        when(companyRepository.findCompanyByCuitAndName(company.getCuit(), company.getName()))
                .thenReturn(Optional.empty());
        when(companyRepository.save(company)).thenReturn(company);

        Company savedCompany = companyService.createCompany(company);

        verify(companyRepository, times(1))
                .findCompanyByCuitAndName(company.getCuit(), company.getName());
        verify(companyRepository, times(1)).save(company);
        assertNotNull(savedCompany.getAdhesionTime());
    }

    @Test
    void testCreateCompany_ThrowsExceptionIfCompanyExists() {
        Company company = new Company();
        company.setCuit("123456789");
        company.setName("Valid Company");

        when(companyRepository.findCompanyByCuitAndName(company.getCuit(), company.getName()))
                .thenReturn(Optional.of(company));

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> companyService.createCompany(company)
        );

        assertEquals("Company already exists", exception.getMessage());
        verify(companyRepository, times(1))
                .findCompanyByCuitAndName(company.getCuit(), company.getName());
        verify(companyRepository, never()).save(any());
    }

    @Test
    void testFindCompaniesWithTransfersLastMonth() {
        List<Company> mockCompanies = List.of(new Company(), new Company());
        when(companyRepository.findCompaniesWithTransfersLastMonth()).thenReturn(mockCompanies);

        List<Company> result = companyService.findCompaniesWithTransfersLastMonth();

        verify(companyRepository, times(1)).findCompaniesWithTransfersLastMonth();
        assertEquals(2, result.size());
    }

    @Test
    void testFindCompaniesJoinedLastMonth() {
        List<Company> mockCompanies = List.of(new Company(), new Company(), new Company());
        when(companyRepository.findCompaniesJoinedLastMonth()).thenReturn(mockCompanies);

        List<Company> result = companyService.findCompaniesJoinedLastMonth();

        verify(companyRepository, times(1)).findCompaniesJoinedLastMonth();
        assertEquals(3, result.size());
    }
}