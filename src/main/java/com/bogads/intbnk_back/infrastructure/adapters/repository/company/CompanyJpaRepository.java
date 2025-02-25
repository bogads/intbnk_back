package com.bogads.intbnk_back.infrastructure.adapters.repository.company;

import com.bogads.intbnk_back.infrastructure.adapters.repository.SoftDeletableRepository;
import com.bogads.intbnk_back.infrastructure.adapters.repository.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyJpaRepository extends SoftDeletableRepository<CompanyEntity> {
    List<CompanyEntity> findByAdhesionTimeAfter(LocalDateTime time);

    @Query("""
                SELECT DISTINCT c FROM companies c 
                JOIN c.accounts a 
                LEFT JOIN a.sender t_sender 
                LEFT JOIN a.receiver t_receiver
                WHERE (t_sender.createdAt >= :oneMonthAgo OR t_receiver.createdAt >= :oneMonthAgo)
            """)
    List<CompanyEntity> findCompaniesWithTransfersLastMonth(@Param("oneMonthAgo") LocalDateTime oneMonthAgo);

    Optional<CompanyEntity> findByNameOrCuit(String name, String cuit);

}
