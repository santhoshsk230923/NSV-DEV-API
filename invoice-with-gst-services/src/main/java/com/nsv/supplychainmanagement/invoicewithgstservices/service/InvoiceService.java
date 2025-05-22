package com.nsv.supplychainmanagement.invoicewithgstservices.service;

import com.nsv.supplychainmanagement.invoicewithgstservices.model.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice createInvoice(Invoice invoice);
    Invoice getInvoiceById(Integer id);
    List<Invoice> getAllInvoices();
    Invoice updateInvoice(Integer id, Invoice invoice);
    void deleteInvoice(Integer id);
}
