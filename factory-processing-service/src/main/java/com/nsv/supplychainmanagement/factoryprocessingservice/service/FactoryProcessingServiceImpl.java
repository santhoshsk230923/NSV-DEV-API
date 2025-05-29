package com.nsv.supplychainmanagement.factoryprocessingservice.service;

import com.nsv.supplychainmanagement.factoryprocessingservice.model.FactoryProcessing;
import com.nsv.supplychainmanagement.factoryprocessingservice.repository.FactoryProcessingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FactoryProcessingServiceImpl implements FactoryProcessingService {

    @Autowired
    private FactoryProcessingRepository repository;

    @Override
    public List<FactoryProcessing> getAll() {
        return repository.findAll();
    }

    @Override
    public FactoryProcessing getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public FactoryProcessing create(FactoryProcessing fp) {
        return repository.save(fp);
    }

    @Override
    public FactoryProcessing update(Integer id, FactoryProcessing fp) {
        FactoryProcessing existing = getById(id);
        fp.setProcessingId(existing.getProcessingId());
        return repository.save(fp);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalProcessed() {
        return repository.getTotalProcessed();
    }

}
