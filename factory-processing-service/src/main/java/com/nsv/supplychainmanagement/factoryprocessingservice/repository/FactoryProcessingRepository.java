package com.nsv.supplychainmanagement.factoryprocessingservice.repository;

import com.nsv.supplychainmanagement.factoryprocessingservice.model.FactoryProcessing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface FactoryProcessingRepository extends JpaRepository<FactoryProcessing, Integer> {

    @Query("SELECT COALESCE(SUM(f.quantityProcessed), 0) FROM FactoryProcessing f")
    BigDecimal getTotalProcessed();
}
