package com.patika.creditscorems.repository;

import com.patika.creditscorems.entity.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CreditRepository extends MongoRepository<Credit, Long> {
    Optional<Credit> findByIdentityNumber(String identityNumber);
}
