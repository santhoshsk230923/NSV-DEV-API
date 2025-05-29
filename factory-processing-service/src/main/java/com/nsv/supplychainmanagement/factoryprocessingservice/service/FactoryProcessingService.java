package com.nsv.supplychainmanagement.factoryprocessingservice.service;

import com.nsv.supplychainmanagement.factoryprocessingservice.model.FactoryProcessing;

import java.math.BigDecimal;
import java.util.List;

public interface FactoryProcessingService {
    List<FactoryProcessing> getAll();
    FactoryProcessing getById(Integer id);
    FactoryProcessing create(FactoryProcessing fp);
    FactoryProcessing update(Integer id, FactoryProcessing fp);
    void delete(Integer id);
    BigDecimal getTotalProcessed();
}
