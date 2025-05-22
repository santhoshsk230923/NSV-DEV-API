package com.nsv.supplychainmanagement.invoicewithoutgstservice.controller;

import com.nsv.supplychainmanagement.invoicewithoutgstservice.model.InvoiceItem;
import com.nsv.supplychainmanagement.invoicewithoutgstservice.service.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoiceWithoutGst")
public class InvoiceItemController {

    @Autowired
    private InvoiceItemService service;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Invoice With out Gst service public endpoint";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read:invoiceWithoutGst')")
    public ResponseEntity<List<InvoiceItem>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read:invoiceWithoutGst')")
    public ResponseEntity<InvoiceItem> getItem(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getItemById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:invoiceWithoutGst')")
    public ResponseEntity<InvoiceItem> createItem(@RequestBody InvoiceItem item) {
        return ResponseEntity.ok(service.createItem(item));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('update:invoiceWithoutGst')")
    public ResponseEntity<InvoiceItem> updateItem(@PathVariable Integer id, @RequestBody InvoiceItem item) {
        return ResponseEntity.ok(service.updateItem(id, item));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('delete:invoiceWithoutGst')")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
