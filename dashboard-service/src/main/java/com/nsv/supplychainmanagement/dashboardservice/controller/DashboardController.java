package com.nsv.supplychainmanagement.dashboardservice.controller;

import com.nsv.supplychainmanagement.dashboardservice.model.DashboardMetrics;
import com.nsv.supplychainmanagement.dashboardservice.service.DashboardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    @Autowired
    private DashboardServiceImpl dashboardService;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "dashboard service public endpoint";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read:dashboard')")
    public DashboardMetrics getMetrics() {
        return dashboardService.getDashboardMetrics();
    }
}
