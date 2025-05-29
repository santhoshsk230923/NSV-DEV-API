package com.nsv.supplychainmanagement.transactionservice.repository;

import com.nsv.supplychainmanagement.transactionservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT COALESCE(SUM(t.amountPaid), 0) FROM Transaction t")
    BigDecimal getTotalAmountPaid();
}
