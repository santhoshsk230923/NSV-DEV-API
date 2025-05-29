package com.nsv.supplychainmanagement.dispatchservice.repository;

import com.nsv.supplychainmanagement.dispatchservice.model.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface DispatchRepository extends JpaRepository<Dispatch, Integer> {

    @Query("SELECT COALESCE(SUM(d.quantityDispatched), 0) FROM Dispatch d")
    BigDecimal getTotalDispatched();
}
