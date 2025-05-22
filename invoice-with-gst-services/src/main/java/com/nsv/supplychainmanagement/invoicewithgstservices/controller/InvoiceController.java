package com.nsv.supplychainmanagement.invoicewithgstservices.controller;


import com.nsv.supplychainmanagement.invoicewithgstservices.model.Invoice;
import com.nsv.supplychainmanagement.invoicewithgstservices.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoiceWithGst")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Invoice service public endpoint";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:invoiceWithGst')")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        System.out.println("Invoice Date: " + invoice.getInvoiceDate());
        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read:invoiceWithGst')")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read:invoiceWithGst')")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('update:invoiceWithGst')")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Integer id, @RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.updateInvoice(id, invoice));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('delete:invoiceWithGst')")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

}
