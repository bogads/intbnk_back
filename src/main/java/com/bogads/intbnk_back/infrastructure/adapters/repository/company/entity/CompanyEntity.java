package com.bogads.intbnk_back.infrastructure.adapters.repository.company.entity;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity(name = "companies")
public class CompanyEntity extends SoftDeletableEntity {
    @Column(name = "razon_social")
    private String name;
    @Column(name = "cuit")
    private String cuit;
    @Column(name = "fecha_de_adhesion")
    private LocalDateTime adhesionTime;

    public CompanyEntity() {
    }

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

    public LocalDateTime getAdhesionTime() {
        return adhesionTime;
    }

    public void setAdhesionTime(LocalDateTime adhesionTime) {
        this.adhesionTime = adhesionTime;
    }
}
