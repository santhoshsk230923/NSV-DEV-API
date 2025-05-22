package com.nsv.supplychainmanagement.supplyservice.service;

import com.nsv.supplychainmanagement.supplyservice.model.Supply;
import com.nsv.supplychainmanagement.supplyservice.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    private SupplyRepository supplyRepository;

    @Override
    public Supply createSupply(Supply supply) {
        return supplyRepository.save(supply);
    }

    @Override
    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    @Override
    public Optional<Supply> getSupplyById(Integer id) {
        return supplyRepository.findById(id);
    }

    @Override
    public Supply updateSupply(Integer id, Supply supply) {
        Supply existing = supplyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supply not found"));
        supply.setSupplyId(existing.getSupplyId());
        return supplyRepository.save(supply);
    }

    @Override
    public void deleteSupply(Integer id) {
        supplyRepository.deleteById(id);
    }
}
