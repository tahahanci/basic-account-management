package org.hncdev.accountmanagement.repository;

import org.hncdev.accountmanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
