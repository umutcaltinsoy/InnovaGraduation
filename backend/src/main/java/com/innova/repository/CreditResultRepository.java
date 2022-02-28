package com.innova.repository;

import com.innova.model.CreditResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditResultRepository extends JpaRepository<CreditResult, Long> {
    CreditResult findByIdentityNumber(String identityNumber);
}
