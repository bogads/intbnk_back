package com.bogads.intbnk_back.domain;

import java.time.LocalDateTime;

public class Company {
    private String id;
    private String cuit;
    private String name;
    private LocalDateTime adhesionTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
    private LocalDateTime deletedAt;

    public Company() {
    }

    public Company(String id, String cuit, String name, LocalDateTime adhesionTime, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isDeleted, LocalDateTime deletedAt) {
        this.id = id;
        this.cuit = cuit;
        this.name = name;
        this.adhesionTime = adhesionTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
        this.deletedAt = deletedAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
