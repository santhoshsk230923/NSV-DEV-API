package com.nsv.supplychainmanagement.supplyservice.service;

import com.nsv.supplychainmanagement.supplyservice.model.Supply;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SupplyService {
    Supply createSupply(Supply supply);
    List<Supply> getAllSupplies();
    Optional<Supply> getSupplyById(Integer id);
    Supply updateSupply(Integer id, Supply supply);
    void deleteSupply(Integer id);
    BigDecimal getTotalSupplyQuantity();
}
