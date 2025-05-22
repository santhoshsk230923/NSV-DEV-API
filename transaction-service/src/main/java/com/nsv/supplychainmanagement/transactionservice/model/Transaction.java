package com.nsv.supplychainmanagement.transactionservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transactions", schema = "nsv_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @JsonProperty("supply_id")
    @Column(name = "supply_id")
    private Integer supplyId;

    @JsonProperty("amount_paid")
    @Column(name = "amount_paid")
    private BigDecimal amountPaid;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;
}
