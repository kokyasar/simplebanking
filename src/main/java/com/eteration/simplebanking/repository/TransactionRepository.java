package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.Id;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
