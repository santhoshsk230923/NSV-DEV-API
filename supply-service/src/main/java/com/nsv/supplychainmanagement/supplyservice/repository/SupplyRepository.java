package com.nsv.supplychainmanagement.supplyservice.repository;

import com.nsv.supplychainmanagement.supplyservice.model.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Integer> {
    // You get all CRUD methods automatically
    @Query("SELECT COALESCE(SUM(s.supplyQuantity), 0) FROM Supply s")
    BigDecimal getTotalSupplyQuantity();
}
