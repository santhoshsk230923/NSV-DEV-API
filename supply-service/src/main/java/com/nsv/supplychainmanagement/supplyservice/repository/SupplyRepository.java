package com.nsv.supplychainmanagement.supplyservice.repository;

import com.nsv.supplychainmanagement.supplyservice.model.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Integer> {
    // You get all CRUD methods automatically
}
