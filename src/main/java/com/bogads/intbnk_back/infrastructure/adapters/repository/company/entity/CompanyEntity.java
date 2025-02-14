package com.bogads.intbnk_back.infrastructure.adapters.repository.company.entity;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity extends SoftDeletableEntity {
    @Column(name = "razon_social")
    private String name;
    @Column(name = "cuit")
    private String cuit;
    @Column(name = "fecha_de_adhesion")
    private LocalDateTime adhesionTime;

}
