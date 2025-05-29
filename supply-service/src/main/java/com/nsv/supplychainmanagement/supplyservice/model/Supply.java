package com.nsv.supplychainmanagement.supplyservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Supply", schema = "nsv_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplyId;

    @JsonProperty("vehicle_no")
    @Column(nullable = false)
    private String vehicleNo;

    @JsonProperty("supply_date")
    @Column(nullable = false)
    private LocalDateTime supplyDate;

    @JsonProperty("dispatch_through")
    private String dispatchThrough;

    @JsonProperty("place_of_supply")
    private String placeOfSupply;

    @JsonProperty("invoice_number")
    @Column(nullable = false, unique = true)
    private String invoiceNumber;

    @JsonProperty("invoice_date")
    @Column(nullable = false)
    private LocalDateTime invoiceDate;

    @JsonProperty("permit_number")
    private String permitNumber;

    @JsonProperty("supply_quantity")
    @Column(name = "supply_quantity",nullable = false, precision = 10, scale = 2)
    private BigDecimal supplyQuantity;

    @JsonProperty("amountPerMT")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amountPerMt;

    @JsonProperty("supplier_id")
    private Integer supplierId;
}
