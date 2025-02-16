package com.bogads.intbnk_back.infrastructure.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCompanyRequest {
    @JsonProperty("razonSocial")
    private String name;
    @JsonProperty("cuit")
    private String cuit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}
