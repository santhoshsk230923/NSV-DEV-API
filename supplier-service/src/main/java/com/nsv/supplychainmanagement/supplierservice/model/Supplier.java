package com.nsv.supplychainmanagement.supplierservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "Suppliers", schema = "nsv_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    @NotBlank(message = "Supplier name is required")
    @Column(name = "supplier_name", nullable = false)
    @JsonProperty("name")
    private String supplierName;

    @Size(max = 20, message = "GST number must not exceed 20 characters")
    @Column(name = "gst_number")
    @JsonProperty("gst_number")
    private String gstNumber;

    @Size(max = 20, message = "PAN number must not exceed 20 characters")
    @Column(name = "pan_number")
    @JsonProperty("pan_number")
    private String panNumber;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Mobile number must be between 10 to 15 digits")
    @Column(name = "mobile_number")
    @JsonProperty("mobile")
    private String mobileNumber;

    @Email(message = "Invalid email format")
    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "address", columnDefinition = "TEXT")
    @JsonProperty("address")
    private String address;

    @Column(name = "hsn_code")
    @JsonProperty("hsn_code")
    private Integer hsnCode;

}
