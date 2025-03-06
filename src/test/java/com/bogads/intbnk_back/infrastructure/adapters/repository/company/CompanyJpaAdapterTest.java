package com.bogads.intbnk_back.infrastructure.adapters.repository.company;

import com.bogads.intbnk_back.domain.Company;
import com.bogads.intbnk_back.infrastructure.adapters.repository.company.entity.CompanyEntity;
import com.bogads.intbnk_back.infrastructure.mapper.company.CompanyMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompanyJpaAdapterTest {

    private CompanyJpaRepository repository;
    private CompanyJpaAdapter adapter;

    @BeforeEach
    void setUp() {
        repository = mock(CompanyJpaRepository.class);
        adapter = new CompanyJpaAdapter(repository);
    }

    @Test
    void testSave_Success() {
        Company company = new Company();
        company.setId("12345");
        company.setName("Test Company");
        company.setCuit("2020202020");

        var mockedEntity = CompanyMapper.toEntity(company);

        when(repository.save(any(CompanyEntity.class))).thenReturn(mockedEntity);

        Company savedCompany = adapter.save(company);

        assertNotNull(savedCompany, "La compañía guardada no debería ser nula");
        assertEquals("12345", savedCompany.getId());
        verify(repository, times(1)).save(any(CompanyEntity.class));
    }

    @Test
    void testFindCompaniesWithTransfersLastMonth() {
        LocalDateTime now = LocalDateTime.now();
        var mockedEntityList = List.of(CompanyMapper.toEntity(new Company()), CompanyMapper.toEntity(new Company()));

        when(repository.findCompaniesWithTransfersLastMonth(any(LocalDateTime.class)))
                .thenReturn(mockedEntityList);

        List<Company> companies = adapter.findCompaniesWithTransfersLastMonth();

        assertEquals(2, companies.size(), "Deberían devolverse exactamente 2 compañías");
        verify(repository, times(1)).findCompaniesWithTransfersLastMonth(any(LocalDateTime.class));
    }

    @Test
    void testFindCompaniesJoinedLastMonth() {
        LocalDateTime now = LocalDateTime.now();
        var mockedEntityList = List.of(
                CompanyMapper.toEntity(new Company()),
                CompanyMapper.toEntity(new Company()),
                CompanyMapper.toEntity(new Company())
        );

        when(repository.findByAdhesionTimeAfter(any(LocalDateTime.class)))
                .thenReturn(mockedEntityList);

        List<Company> companies = adapter.findCompaniesJoinedLastMonth();

        assertEquals(3, companies.size(), "Deberían devolverse exactamente 3 compañías");
        verify(repository, times(1)).findByAdhesionTimeAfter(any(LocalDateTime.class));
    }

    @Test
    void testFindCompanyById_Found() {
        String companyId = "12345";
        var mockedEntity = CompanyMapper.toEntity(new Company());
        mockedEntity.setId(companyId);

        when(repository.findById(companyId)).thenReturn(Optional.of(mockedEntity));

        Optional<Company> result = adapter.findCompanyById(companyId);

        assertTrue(result.isPresent(), "La compañía debería estar presente");
        assertEquals(companyId, result.get().getId(), "El ID de la compañía debería coincidir");
        verify(repository, times(1)).findById(companyId);
    }

    @Test
    void testFindCompanyById_NotFound() {
        String companyId = "12345";

        when(repository.findById(companyId)).thenReturn(Optional.empty());

        Optional<Company> result = adapter.findCompanyById(companyId);

        assertTrue(result.isEmpty(), "La compañía no debería estar presente");
        verify(repository, times(1)).findById(companyId);
    }

    @Test
    void testFindCompanyByCuitAndName_Found() {
        String cuit = "2020202020";
        String name = "Test Company";
        var mockedEntity = CompanyMapper.toEntity(new Company());
        mockedEntity.setCuit(cuit);
        mockedEntity.setName(name);

        when(repository.findByNameOrCuit(cuit, name)).thenReturn(Optional.of(mockedEntity));

        Optional<Company> result = adapter.findCompanyByCuitAndName(cuit, name);

        assertTrue(result.isPresent(), "La compañía debería estar presente");
        assertEquals(cuit, result.get().getCuit(), "El CUIT debería coincidir");
        assertEquals(name, result.get().getName(), "El nombre debería coincidir");
        verify(repository, times(1)).findByNameOrCuit(cuit, name);
    }

    @Test
    void testFindCompanyByCuitAndName_NotFound() {
        String cuit = "2020202020";
        String name = "Test Company";

        when(repository.findByNameOrCuit(cuit, name)).thenReturn(Optional.empty());

        Optional<Company> result = adapter.findCompanyByCuitAndName(cuit, name);

        assertTrue(result.isEmpty(), "La compañía no debería estar presente");
        verify(repository, times(1)).findByNameOrCuit(cuit, name);
    }
}