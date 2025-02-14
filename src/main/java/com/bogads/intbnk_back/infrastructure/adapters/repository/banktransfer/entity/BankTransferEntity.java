package com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer.entity;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name = "bank_transfers")
@Getter
@Setter
@Builder
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BankTransferEntity extends SoftDeletableEntity {

}
