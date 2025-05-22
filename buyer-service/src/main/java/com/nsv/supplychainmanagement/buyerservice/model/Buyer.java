package com.nsv.supplychainmanagement.buyerservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Buyers", schema = "nsv_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("buyer_id")
    private Integer buyerId;

    @Column(name = "buyer_name", nullable = false)
    @JsonProperty("buyer_name")
    private String buyerName;

    @Column(columnDefinition = "TEXT")
    @JsonProperty("address")
    private String address;

    @Column(name = "gst_number", length = 20)
    @JsonProperty("gst_number")
    private String gstNumber;

    @Column(length = 50)
    @JsonProperty("state")
    private String state;

    @Column(name = "state_code")
    @JsonProperty("state_code")
    private Integer stateCode;
}
