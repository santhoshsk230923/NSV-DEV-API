package com.nsv.supplychainmanagement.transactionservice.service;

import com.nsv.supplychainmanagement.transactionservice.model.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransactionService {

    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransactionById(Integer id);
    Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(Integer id, Transaction transaction);
    void deleteTransaction(Integer id);
    BigDecimal getTotalAmountPaid();
}
