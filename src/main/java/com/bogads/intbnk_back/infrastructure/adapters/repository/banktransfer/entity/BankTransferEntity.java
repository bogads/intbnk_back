package com.bogads.intbnk_back.infrastructure.adapters.repository.banktransfer.entity;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableEntity;
import jakarta.persistence.Entity;

@Entity(name = "bank_transfers")
public class BankTransferEntity extends SoftDeletableEntity {


}
