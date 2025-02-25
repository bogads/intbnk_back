package com.bogads.intbnk_back.infrastructure.controller;

import com.bogads.intbnk_back.application.port.service.CompanyService;
import com.bogads.intbnk_back.domain.Company;
import com.bogads.intbnk_back.infrastructure.controller.request.CreateCompanyRequest;
import com.bogads.intbnk_back.infrastructure.controller.response.CreateCompanyResponse;
import com.bogads.intbnk_back.infrastructure.mapper.company.CompanyMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bogads.intbnk_back.infrastructure.utils.ApiConstants.*;

@RestController
@RequestMapping(API_V1_COMPANIES)
public class CompanyRestController {

    private final CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping()
    public CreateCompanyResponse createCompany(@Valid @RequestBody CreateCompanyRequest request) {
        var companyResult = companyService.createCompany(CompanyMapper.toModel(request));
        return CompanyMapper.toCreateCompanyResponse(companyResult);
    }

    @GetMapping(JOINED_LAST_MONTH)
    public List<Company> findCompaniesJoinedLastMonth() {
        return companyService.findCompaniesJoinedLastMonth();
    }

    @GetMapping(TRANSFER_LAST_MONTH)
    public List<Company> findCompaniesWithTransfersLastMonth() {
        return companyService.findCompaniesWithTransfersLastMonth();
    }

}
