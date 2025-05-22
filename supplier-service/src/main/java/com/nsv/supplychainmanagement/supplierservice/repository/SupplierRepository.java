package com.nsv.supplychainmanagement.supplierservice.repository;

import com.nsv.supplychainmanagement.supplierservice.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}

