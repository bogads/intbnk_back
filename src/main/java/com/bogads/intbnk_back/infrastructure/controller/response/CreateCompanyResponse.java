package com.bogads.intbnk_back.infrastructure.controller.response;

import java.time.LocalDateTime;

public class CreateCompanyResponse {
    private String id;
    private String cuit;
    private String name;
    private LocalDateTime adhesionTime;

    public CreateCompanyResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getAdhesionTime() {
        return adhesionTime;
    }

    public void setAdhesionTime(LocalDateTime adhesionTime) {
        this.adhesionTime = adhesionTime;
    }
}
