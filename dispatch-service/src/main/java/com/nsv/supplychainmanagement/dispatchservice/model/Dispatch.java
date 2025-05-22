package com.nsv.supplychainmanagement.dispatchservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Dispatch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dispatchId;

    @JsonProperty("buyer_name")
    @Column(nullable = false)
    private String buyerName;

    @JsonProperty("buyer_details")
    @Column(columnDefinition = "TEXT")
    private String buyerDetails;

    @JsonProperty("dispatch_vehicle_number")
    private String dispatchVehicleNo;

    @JsonProperty("quantity_dispatched")
    private BigDecimal quantityDispatched;

    @JsonProperty("selling_price_per_mt")
    private BigDecimal sellingPricePerMt;

    @JsonProperty("dispatch_date_time")
    @Column(nullable = false)
    private LocalDateTime dispatchDate;
}
