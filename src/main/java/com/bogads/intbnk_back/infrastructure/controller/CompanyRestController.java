package com.bogads.intbnk_back.infrastructure.controller;

import com.bogads.intbnk_back.application.port.service.CompanyService;
import com.bogads.intbnk_back.infrastructure.controller.request.CreateCompanyRequest;
import com.bogads.intbnk_back.infrastructure.controller.response.CreateCompanyResponse;
import com.bogads.intbnk_back.infrastructure.mapper.company.CompanyMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bogads.intbnk_back.infrastructure.utils.ApiConstants.API_V1_COMPANIES;

@RestController
@RequestMapping(API_V1_COMPANIES)
@Slf4j
public class CompanyRestController {

    private final CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping()
    public CreateCompanyResponse createCompany(@Valid @RequestBody CreateCompanyRequest request) {
        companyService.createCompany(CompanyMapper.toModel(request));
    }
}
