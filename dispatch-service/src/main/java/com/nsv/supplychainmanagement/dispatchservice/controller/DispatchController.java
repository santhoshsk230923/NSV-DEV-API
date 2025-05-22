package com.nsv.supplychainmanagement.dispatchservice.controller;

import com.nsv.supplychainmanagement.dispatchservice.model.Dispatch;
import com.nsv.supplychainmanagement.dispatchservice.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {
    @Autowired
    private DispatchService dispatchService;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Dispatch service public endpoint";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:dispatch')")
    public ResponseEntity<Dispatch> createDispatch(@RequestBody Dispatch dispatch) {
        return ResponseEntity.ok(dispatchService.createDispatch(dispatch));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read:dispatch')")
    public ResponseEntity<List<Dispatch>> getAllDispatches() {
        return ResponseEntity.ok(dispatchService.getAllDispatches());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read:dispatch')")
    public ResponseEntity<Dispatch> getDispatchById(@PathVariable Integer id) {
        return dispatchService.getDispatchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('update:dispatch')")
    public ResponseEntity<Dispatch> updateDispatch(@PathVariable Integer id, @RequestBody Dispatch dispatch) {
        return ResponseEntity.ok(dispatchService.updateDispatch(id, dispatch));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('delete:dispatch')")
    public ResponseEntity<Void> deleteDispatch(@PathVariable Integer id) {
        dispatchService.deleteDispatch(id);
        return ResponseEntity.noContent().build();
    }
}
