package com.bogads.intbnk_back.infrastructure.mapper.company;

import com.bogads.intbnk_back.domain.Company;
import com.bogads.intbnk_back.infrastructure.adapters.repository.company.entity.CompanyEntity;
import com.bogads.intbnk_back.infrastructure.controller.request.CreateCompanyRequest;
import jakarta.validation.Valid;

public final class CompanyMapper {
    private CompanyMapper() {
    }

    public static CompanyEntity toEntity(Company company) {
        var entity = new CompanyEntity();
        entity.setId(company.getId());
        entity.setCuit(company.getCuit());
        entity.setAdhesionTime(company.getAdhesionTime());
        entity.setName(company.getName());
        entity.setCreatedAt(company.getCreatedAt());
        entity.setUpdatedAt(company.getUpdatedAt());
        return entity;
    }

    public static Company toModel(CompanyEntity entity) {
        var model = new Company();
        model.setId(entity.getId());
        model.setCuit(entity.getCuit());
        model.setAdhesionTime(entity.getAdhesionTime());
        model.setName(entity.getName());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static Company toModel(@Valid CreateCompanyRequest request) {
        var model = new Company();
        model.setCuit(request.getCuit());
        model.setName(request.getName());
        return model;
    }
}
