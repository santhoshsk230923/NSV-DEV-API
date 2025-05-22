package com.nsv.supplychainmanagement.factoryprocessingservice.repository;

import com.nsv.supplychainmanagement.factoryprocessingservice.model.FactoryProcessing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactoryProcessingRepository extends JpaRepository<FactoryProcessing, Integer> {
}
