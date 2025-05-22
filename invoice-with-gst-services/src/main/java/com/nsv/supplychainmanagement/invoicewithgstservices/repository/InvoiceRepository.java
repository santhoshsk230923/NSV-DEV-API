package com.nsv.supplychainmanagement.invoicewithgstservices.repository;

import com.nsv.supplychainmanagement.invoicewithgstservices.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}