package com.nsv.supplychainmanagement.invoicewithgstservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Invoices", schema = "nsv_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;

    @JsonProperty("invoice_number")
    @Column(nullable = false, unique = true)
    private String invoiceNumber;

    @JsonProperty("invoice_date")
    @Column(nullable = false)
    private LocalDateTime invoiceDate;

    @JsonProperty("vehicle_number")
    private String vehicleNumber;

    @JsonProperty("date_of_supply")
    private LocalDateTime dateOfSupply;

    @JsonProperty("dispatch_through")
    private String dispatchThrough;

    @JsonProperty("dispatch_document_no")
    private String dispatchDocumentNo;

    @JsonProperty("place_of_supply")
    private String placeOfSupply;

    @JsonProperty("buyer_id")
    private Integer buyerId;

    @JsonProperty("total_before_tax")
    private BigDecimal totalBeforeTax;

    @JsonProperty("cgst")
    private BigDecimal cgst;

    @JsonProperty("sgst")
    private BigDecimal sgst;

    @JsonProperty("igst")
    private BigDecimal igst;

    @JsonProperty("total_after_tax")
    private BigDecimal totalAfterTax;
}
