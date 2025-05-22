package com.nsv.supplychainmanagement.transactionservice.controller;

import com.nsv.supplychainmanagement.transactionservice.model.Transaction;
import com.nsv.supplychainmanagement.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Transaction service public endpoint";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read:transactions')")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read:transactions')")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id) {
        return transactionService.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:transactions')")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        log.info("📦 Creating transaction for supplyId={} with amount={}",
                transaction.getSupplyId(), transaction.getAmountPaid());
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('update:transactions')")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.updateTransaction(id, transaction));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('delete:transactions')")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

}
