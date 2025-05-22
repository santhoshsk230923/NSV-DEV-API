package com.nsv.supplychainmanagement.invoicewithoutgstservice.repository;

import com.nsv.supplychainmanagement.invoicewithoutgstservice.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer> {
}