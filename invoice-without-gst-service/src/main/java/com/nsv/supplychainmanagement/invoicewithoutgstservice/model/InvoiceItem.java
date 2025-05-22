package com.nsv.supplychainmanagement.invoicewithoutgstservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Invoice_Items", schema = "nsv_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    private Integer invoiceId;

    private String description;

    private String hsnSacCode;

    private Integer quantity;

    private BigDecimal rate;

    private BigDecimal totalAmount;
}
