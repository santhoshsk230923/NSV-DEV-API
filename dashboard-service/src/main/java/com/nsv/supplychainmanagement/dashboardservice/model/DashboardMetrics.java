package com.nsv.supplychainmanagement.dashboardservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardMetrics {
    @JsonProperty("totalSupplyReceived")
    private BigDecimal totalSupplyReceived;

    @JsonProperty("totalProcessed")
    private BigDecimal totalProcessed;

    @JsonProperty("totalDispatched")
    private BigDecimal totalDispatched;

    @JsonProperty("totalWaste")
    private BigDecimal totalWaste;

    @JsonProperty("totalAmountPaid")
    private BigDecimal totalAmountPaid;

    @JsonProperty("totalRevenue")
    private BigDecimal totalRevenue;

    @JsonProperty("averagePricePerMT")
    private BigDecimal averagePricePerMT;

    @JsonProperty("processingEfficiency")
    private BigDecimal processingEfficiency;

    @JsonProperty("dispatchEfficiency")
    private BigDecimal dispatchEfficiency;

    @JsonProperty("wastePercentage")
    private BigDecimal wastePercentage;
}