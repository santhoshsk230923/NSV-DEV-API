package com.nsv.supplychainmanagement.supplierservice.service;

import com.nsv.supplychainmanagement.supplierservice.model.Supplier;
import com.nsv.supplychainmanagement.supplierservice.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Integer id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
    }

    @Override
    public Supplier updateSupplier(Integer id, Supplier supplier) {
        Supplier existing = getSupplierById(id);
        existing.setSupplierName(supplier.getSupplierName());
        existing.setGstNumber(supplier.getGstNumber());
        existing.setPanNumber(supplier.getPanNumber());
        existing.setMobileNumber(supplier.getMobileNumber());
        existing.setEmail(supplier.getEmail());
        existing.setAddress(supplier.getAddress());
        return supplierRepository.save(existing);
    }

    @Override
    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }
}
