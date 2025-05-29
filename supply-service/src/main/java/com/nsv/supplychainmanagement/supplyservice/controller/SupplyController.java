package com.nsv.supplychainmanagement.supplyservice.controller;

import com.nsv.supplychainmanagement.supplyservice.model.Supply;
import com.nsv.supplychainmanagement.supplyservice.service.SupplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/supplies")
@RequiredArgsConstructor
@Slf4j
public class SupplyController {

    @Autowired
    private SupplyService supplyService;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Supply service public endpoint";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:supplies')")
    public ResponseEntity<Supply> createSupply(@RequestBody Supply supply) {
        System.out.println("AmountPerMt from request: " + supply.getAmountPerMt());
        return ResponseEntity.ok(supplyService.createSupply(supply));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read:supplies')")
    public ResponseEntity<List<Supply>> getAllSupplies() {
        return ResponseEntity.ok(supplyService.getAllSupplies());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read:supplies')")
    public ResponseEntity<Supply> getSupplyById(@PathVariable Integer id) {
        return supplyService.getSupplyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('update:supplies')")
    public ResponseEntity<Supply> updateSupply(@PathVariable Integer id, @RequestBody Supply supply) {
        return ResponseEntity.ok(supplyService.updateSupply(id, supply));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('delete:supplies')")
    public ResponseEntity<Void> deleteSupply(@PathVariable Integer id) {
        supplyService.deleteSupply(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total-quantity")
    @PreAuthorize("hasAuthority('read:supplies')")
    public ResponseEntity<BigDecimal> getTotalSupplyQuantity() {
        log.info("========>>"+ supplyService.getTotalSupplyQuantity());
        return ResponseEntity.ok(supplyService.getTotalSupplyQuantity());
    }
}
