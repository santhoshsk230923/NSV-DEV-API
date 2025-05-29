package com.nsv.supplychainmanagement.invoicewithgstservices.repository;

import com.nsv.supplychainmanagement.invoicewithgstservices.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("SELECT COALESCE(SUM(i.totalAfterTax), 0) FROM Invoice i")
    BigDecimal getTotalRevenue();

}