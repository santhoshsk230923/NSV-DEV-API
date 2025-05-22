package com.nsv.supplychainmanagement.factoryprocessingservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Factory_Processing", schema = "nsv_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactoryProcessing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer processingId;

    @JsonProperty("supply_id")
    private Integer supplyId;

    @JsonProperty("quantity_received")
    @Column(nullable = false)
    private BigDecimal quantityReceived;

    @JsonProperty("quantity_processed")
    private BigDecimal quantityProcessed;

    @JsonProperty("waste_per_mt")
    private BigDecimal wastePerMt;

    @JsonProperty("qty_alloyed_per_day")
    private BigDecimal qtyAlloyedPerDay;

    @JsonProperty("processing_date")
    @Column(nullable = false)
    private LocalDateTime processingDate;
}
