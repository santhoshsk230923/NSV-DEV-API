package com.nsv.supplychainmanagement.supplierservice.service;

import com.nsv.supplychainmanagement.supplierservice.model.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(Integer id);
    Supplier updateSupplier(Integer id, Supplier supplier);
    void deleteSupplier(Integer id);
}
