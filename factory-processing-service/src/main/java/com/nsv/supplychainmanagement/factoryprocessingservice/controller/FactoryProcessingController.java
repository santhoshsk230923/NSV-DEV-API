package com.nsv.supplychainmanagement.factoryprocessingservice.controller;

import com.nsv.supplychainmanagement.factoryprocessingservice.model.FactoryProcessing;
import com.nsv.supplychainmanagement.factoryprocessingservice.service.FactoryProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/factoryProcessing")
public class FactoryProcessingController {

    @Autowired
    private FactoryProcessingService factoryProcessingService;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Factory Processing service public endpoint";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read:factoryProcessing')")
    public ResponseEntity<List<FactoryProcessing>> getAll() {
        return ResponseEntity.ok(factoryProcessingService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read:factoryProcessing')")
    public ResponseEntity<FactoryProcessing> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(factoryProcessingService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:factoryProcessing')")
    public ResponseEntity<FactoryProcessing> create(@RequestBody FactoryProcessing fp) {
        return ResponseEntity.ok(factoryProcessingService.create(fp));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('update:factoryProcessing')")
    public ResponseEntity<FactoryProcessing> update(@PathVariable Integer id, @RequestBody FactoryProcessing fp) {
        return ResponseEntity.ok(factoryProcessingService.update(id, fp));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('delete:factoryProcessing')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        factoryProcessingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total-processed")
    public ResponseEntity<BigDecimal> getTotalProcessed() {
        return ResponseEntity.ok(factoryProcessingService.getTotalProcessed());
    }

}
