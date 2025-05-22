package com.nsv.supplychainmanagement.buyerservice.controller;

import com.nsv.supplychainmanagement.buyerservice.model.Buyer;
import com.nsv.supplychainmanagement.buyerservice.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "buyers service public endpoint";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:buyer')")
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
        return ResponseEntity.ok(buyerService.createBuyer(buyer));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read:buyer')")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable Integer id) {
        return ResponseEntity.ok(buyerService.getBuyerById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read:buyer')")
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        return ResponseEntity.ok(buyerService.getAllBuyers());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('update:buyer')")
    public ResponseEntity<Buyer> updateBuyer(@PathVariable Integer id, @RequestBody Buyer buyer) {
        return ResponseEntity.ok(buyerService.updateBuyer(id, buyer));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ddelete:buyer')")
    public ResponseEntity<Void> deleteBuyer(@PathVariable Integer id) {
        buyerService.deleteBuyer(id);
        return ResponseEntity.noContent().build();
    }
}
