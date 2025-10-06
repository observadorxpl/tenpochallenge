package com.tempo.challenge.tenpochallenge.repository;

import com.tempo.challenge.tenpochallenge.model.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    Page<Transaction> findAll(Pageable pageable);
}
