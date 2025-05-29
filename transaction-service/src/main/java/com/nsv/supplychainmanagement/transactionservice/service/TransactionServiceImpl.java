package com.nsv.supplychainmanagement.transactionservice.service;

import com.nsv.supplychainmanagement.transactionservice.model.Transaction;
import com.nsv.supplychainmanagement.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Override
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setTransactionDate(LocalDateTime.now());
        return repository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Integer id, Transaction updatedTransaction) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setSupplyId(updatedTransaction.getSupplyId());
                    existing.setAmountPaid(updatedTransaction.getAmountPaid());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public void deleteTransaction(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalAmountPaid() {
        return repository.getTotalAmountPaid();
    }
}
